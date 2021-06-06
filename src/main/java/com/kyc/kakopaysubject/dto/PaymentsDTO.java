package com.kyc.kakopaysubject.dto;

import com.kyc.kakaopaysubject.entity.Payments;

public class PaymentsDTO {

	
	private int paymentId;
	
	private int accountId;
	
	private int amount;
	
	private String methodType;
	
	private String itemCategory;
	
	private String region;
	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Payments toEntity() {
		return new Payments(paymentId, accountId, amount, methodType, itemCategory, region); 		
	}
	
	
	
}
