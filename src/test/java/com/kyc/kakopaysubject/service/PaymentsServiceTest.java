package com.kyc.kakopaysubject.service;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kyc.kakaopaysubject.KakaopaySubjectDataServiceApplication;
import com.kyc.kakaopaysubject.repository.PaymentRepository;
import com.kyc.kakopaysubject.dto.PaymentsDTO;
import com.kyc.kakopaysubject.util.ReadCsvFileUtil;


@Transactional
@SpringBootTest(classes=KakaopaySubjectDataServiceApplication.class)
public class PaymentsServiceTest {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	ReadCsvFileUtil readCsvFileUtil; 
	
	@Autowired
	PaymentsService paymentsService;
	
	
	@Test
	public void paymentsSaveTest() throws Exception{
		PaymentsDTO payments = new PaymentsDTO();
		paymentsService.savePayments(payments);
	}
	
	@Test
	public void paymentsStatisticsTest() throws Exception{
		String groupId = "GROUP_3";
		
		paymentsService.requestStatisticsByGroupId(groupId);
	}
	
}
