package com.orangeven.qiafan.app.business.model;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.orangeven.qiafan.app.common.model.AbstractEmbedModel;

public class BusinessWallet extends AbstractEmbedModel {
	@Column(name = "owner_id")
	private Long ownerId;
	@Column(name = "total_amount")
	private BigDecimal totalAmount;
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
