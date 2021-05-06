package com.orangeven.qiafan.app.common.model.order;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.orangeven.qiafan.app.common.enumeration.order.RefundState;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
@Table(name = "customer_delivery_order_refund_application")
public class RefundApplication extends AbstractOwnedEntityModel {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "refund-application-id-generator"
	)
	@SequenceGenerator(
			name = "refund-application-id-generator",
			sequenceName = "customer_delivery_order_refund_application_id_seq",
			initialValue = 99,
			allocationSize = 1
	)
	private Long id;
	private Long orderId;
	private Long mechandiseSegmentId;
	@Enumerated(EnumType.STRING)
	private RefundState refundState;
	@Temporal(TemporalType.TIMESTAMP)
	private Date refundAppliedDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date refundCanceledDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date refundAgreedDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date refundRefusedDateTime;
	public RefundState getRefundState() {
		return refundState;
	}
	public void setRefundState(RefundState refundState) {
		this.refundState = refundState;
	}
	public Date getRefundAppliedDateTime() {
		return refundAppliedDateTime;
	}
	public void setRefundAppliedDateTime(Date refundAppliedDateTime) {
		this.refundAppliedDateTime = refundAppliedDateTime;
	}
	public Date getRefundCanceledDateTime() {
		return refundCanceledDateTime;
	}
	public void setRefundCanceledDateTime(Date refundCanceledDateTime) {
		this.refundCanceledDateTime = refundCanceledDateTime;
	}
	public Date getRefundAgreedDateTime() {
		return refundAgreedDateTime;
	}
	public void setRefundAgreedDateTime(Date refundAgreedDateTime) {
		this.refundAgreedDateTime = refundAgreedDateTime;
	}
	public Date getRefundRefusedDateTime() {
		return refundRefusedDateTime;
	}
	public void setRefundRefusedDateTime(Date refundRefusedDateTime) {
		this.refundRefusedDateTime = refundRefusedDateTime;
	}
	public Long getId() {
		return id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public long getMechandiseSegmentId() {
		return mechandiseSegmentId;
	}
	public void setMechandiseSegmentId(Long mechandiseSegmentId) {
		this.mechandiseSegmentId = mechandiseSegmentId;
	}
	
	
}
