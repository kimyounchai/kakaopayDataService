package com.kyc.kakaopaysubject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;



@Entity
@AllArgsConstructor
@Table(name = "accounts")
public class Accounts {
	
	@Id
	private int accountId;
	
	@Column
	private String residence;
	
	@Column
	private int age;

}
