package com.orangeven.qiafan.app.common.model.order;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.orangeven.qiafan.app.common.enumeration.order.DiscountType;
import com.orangeven.qiafan.app.common.enumeration.order.DistributorType;
import com.orangeven.qiafan.app.common.model.AbstractEntityModel;

@Entity
public class CouponPool extends AbstractEntityModel {

	@Id
	@SequenceGenerator(
			name = "coupon-pool-id-generator",
			initialValue = 99,
			allocationSize = 1,
			sequenceName = ""
	)
	@GeneratedValue(
			generator = "coupon-pool-id-generator",
			strategy = GenerationType.SEQUENCE
	)
	private Long id;
	private String name;
	private String title;
	private Long publisherId;
	private Long businessId;
	@Enumerated(EnumType.STRING)
	private DiscountType discountType;
	@Enumerated(EnumType.STRING)
	private DistributorType distributorType;
	private int totalAmount;
	private int availableLeft;
	private int availablePerAccount;
	private Date effectiveTimestamp;
	private Date expiryTimestamp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}
	public Long getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}
	public DiscountType getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	public DistributorType getDistributorType() {
		return distributorType;
	}
	public void setDistributorType(DistributorType distributorType) {
		this.distributorType = distributorType;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getAvailableLeft() {
		return availableLeft;
	}
	public void setAvailableLeft(int availableLeft) {
		this.availableLeft = availableLeft;
	}
	public int getAvailablePerAccount() {
		return availablePerAccount;
	}
	public void setAvailablePerAccount(int availablePerAccount) {
		this.availablePerAccount = availablePerAccount;
	}
	public Date getEffectiveTimestamp() {
		return effectiveTimestamp;
	}
	public void setEffectiveTimestamp(Date effectiveTimestamp) {
		this.effectiveTimestamp = effectiveTimestamp;
	}
	public Date getExpiryTimestamp() {
		return expiryTimestamp;
	}
	public void setExpiryTimestamp(Date expiryTimestamp) {
		this.expiryTimestamp = expiryTimestamp;
	}
	public Long getId() {
		return id;
	}
	
}
