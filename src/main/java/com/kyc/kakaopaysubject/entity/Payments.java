package com.kyc.kakaopaysubject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;


@Entity
@AllArgsConstructor
@Table(name = "payments")
public class Payments {
	
	@Id
	private int paymentId;
	
	@Column
	private int accountId;
	
	@Column
	private int amount;
	
	@Column
	private String methodType;
	
	@Column
	private String itemCategory;
	
	@Column
	private String region;

	public Payments() {
		super();
	}
	
}
