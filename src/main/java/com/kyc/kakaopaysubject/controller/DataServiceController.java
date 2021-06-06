package com.kyc.kakaopaysubject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kyc.kakaopaysubject.exception.DataServiceErrorResponse;
import com.kyc.kakopaysubject.dto.PaymentsDTO;
import com.kyc.kakopaysubject.dto.StatisticsDTO;
import com.kyc.kakopaysubject.service.PaymentsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class DataServiceController {
	
	private final PaymentsService paymentsService;
	
	@PostMapping(value="/payment")
	public ResponseEntity<DataServiceErrorResponse>  requestPayments(@RequestBody final PaymentsDTO payments) throws Exception{
		return ResponseEntity.ok(paymentsService.savePayments(payments));
	}
	
	
	@GetMapping("/statistics")
	public ResponseEntity<StatisticsDTO>  requestStatistics(@RequestParam String groupId) throws Exception{			
		return ResponseEntity.ok(paymentsService.requestStatisticsByGroupId(groupId));
	}
}

