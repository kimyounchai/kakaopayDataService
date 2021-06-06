package com.kyc.kakopaysubject.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StatisticsDTO {

	
	private String groupId;
	
	private int count;
	
	private int totalAmount;
	
	private int avgAmount;
	
	private int minAmount;
	
	private int maxAmount;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getAvgAmount() {
		return avgAmount;
	}

	public void setAvgAmount(int avgAmount) {
		this.avgAmount = avgAmount;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	public StatisticsDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
