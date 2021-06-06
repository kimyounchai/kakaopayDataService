package com.kyc.kakaopaysubject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kyc.kakaopaysubject.repository.PaymentRepository;
import com.kyc.kakopaysubject.service.PaymentsService;
import com.kyc.kakopaysubject.util.ReadCsvFileUtil;

@Configuration
public class DataServiceConfiguration {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ReadCsvFileUtil readCsvFileUtil;
	
	@Bean
	public PaymentsService paymentsService(){
		return new PaymentsService(paymentRepository, readCsvFileUtil);
	}
	
	@Bean
	public ReadCsvFileUtil readCsvFileUtilConfig() {
		return new ReadCsvFileUtil();
	}
}
