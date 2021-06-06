package com.kyc.kakopaysubject.dto;

import com.kyc.kakaopaysubject.entity.Accounts;

public class AccountsDTO {

	private int accountId;
	
	private String residence;
	
	private int age;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Accounts toEntity() {
		// TODO Auto-generated method stub
		return new Accounts(accountId, residence, age);
	}
	
	
	
}
