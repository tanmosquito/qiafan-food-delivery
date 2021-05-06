package com.orangeven.qiafan.app.customer.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orangeven.qiafan.app.common.enumeration.order.DistributorType;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
@Table(name = "customer_coupon")
public class Coupon extends AbstractOwnedEntityModel {

	@Id
	@SequenceGenerator(
			name = "coupon-id-generator",
			sequenceName = "customer_coupon_id_seq",
			initialValue = 99,
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "coupon-id-generator"
	)
	private Long id;
	private String name;
	private DistributorType type;
	private BigDecimal requiredTotalAmount;
	private double discount;
	private Date availableStartDateTime;
	private long duration;
	private Date acqusitionDateTime;
	private boolean used;
	private Date usedDateTime;
	private Long appliedOrderId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DistributorType getType() {
		return type;
	}
	public void setType(DistributorType type) {
		this.type = type;
	}
	public BigDecimal getRequiredTotalAmount() {
		return requiredTotalAmount;
	}
	public void setRequiredTotalAmount(BigDecimal requiredTotalAmount) {
		this.requiredTotalAmount = requiredTotalAmount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Date getAvailableStartDateTime() {
		return availableStartDateTime;
	}
	public void setAvailableStartDateTime(Date availableStartDateTime) {
		this.availableStartDateTime = availableStartDateTime;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public Date getAcqusitionDateTime() {
		return acqusitionDateTime;
	}
	public void setAcqusitionDateTime(Date acqusitionDateTime) {
		this.acqusitionDateTime = acqusitionDateTime;
	}
	public Long getId() {
		return id;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public Date getUsedDateTime() {
		return usedDateTime;
	}
	public void setUsedDateTime(Date usedDateTime) {
		this.usedDateTime = usedDateTime;
	}
	public long getAppliedOrderId() {
		return appliedOrderId;
	}
	public void setAppliedOrderId(Long appliedOrderId) {
		this.appliedOrderId = appliedOrderId;
	}
}
