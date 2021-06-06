package com.kyc.kakopaysubject.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kyc.kakaopaysubject.entity.Payments;
import com.kyc.kakaopaysubject.exception.DataServiceErrorResponse;
import com.kyc.kakaopaysubject.repository.PaymentRepository;
import com.kyc.kakopaysubject.dto.PaymentsDTO;
import com.kyc.kakopaysubject.dto.StatisticsDTO;
import com.kyc.kakopaysubject.util.ReadCsvFileUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentsService {
	
	private final PaymentRepository paymentRepository;
	
	private final ReadCsvFileUtil readCsvFileUtil; 
	
	@Transactional
	public DataServiceErrorResponse savePayments(final PaymentsDTO payments) throws IOException{
		
		List<Map<String, String>> csvList = new ArrayList<Map<String,String>>();
		
		try {
			csvList = readCsvFileUtil.recvPaymentFile();
		} catch(IOException e) {
			return new DataServiceErrorResponse(false, e.getMessage()); 
		}
		
		for(int i=0 ; i<csvList.size() ; i++) {
			payments.setPaymentId(Integer.parseInt(csvList.get(i).get("paymentId")));
			payments.setAccountId(Integer.parseInt(csvList.get(i).get("accountId")));
			payments.setAmount(Integer.parseInt(csvList.get(i).get("amount")));
			payments.setMethodType(csvList.get(i).get("methodType"));
			payments.setItemCategory(csvList.get(i).get("itemCategory"));
			payments.setRegion(csvList.get(i).get("region"));
			
			Payments paymentsEntity = payments.toEntity();
			paymentRepository.save(paymentsEntity);
		}
		
		return new DataServiceErrorResponse(true, "");
	}
	
	@Transactional
	public StatisticsDTO requestStatisticsByGroupId(String groupId) throws Exception {
		StatisticsDTO rsltDto = new StatisticsDTO();
		List<Object[]> obj = new ArrayList<Object[]>();
		
		if(groupId.equals("GROUP_1")) {
			obj = paymentRepository.findByGroupId1();
		}else if(groupId.equals("GROUP_2")) {
			obj = paymentRepository.findByGroupId2();
		}else if(groupId.equals("GROUP_3")) {
			String accountId = "3";	// 결제자 임의 지정
			obj = paymentRepository.findByGroupId3(accountId);
		}else if(groupId.equals("GROUP_4")) {
			obj = paymentRepository.findByGroupId4();
		}
		
		if(!obj.isEmpty()) {
			rsltDto = new StatisticsDTO(obj.get(0)[0].toString()
					, Integer.parseInt(obj.get(0)[1].toString())
					, Integer.parseInt(obj.get(0)[2].toString())
					, Integer.parseInt(obj.get(0)[3].toString())
					, Integer.parseInt(obj.get(0)[4].toString())
					, Integer.parseInt(obj.get(0)[5].toString()));
		}
		
		return rsltDto; 
	}
	
	
}
