package com.orangeven.qiafan.app.common.model.order;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.orangeven.qiafan.app.common.enumeration.order.PaymentMethod;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
public class PaymentInformation extends AbstractOwnedEntityModel{

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "order-payment-information-id-generator"
	)
	@SequenceGenerator(
			name = "order-payent-information-id-generator",
			sequenceName = "customer_delivery_order_payment_information_id_seq",
			initialValue = 99,
			allocationSize = 1
	)
	private Long id;
	private Long orderId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentOrderDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date paiedDateTime;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	private double amountsPayable;
	private double actuallyPaied;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getPaymentOrderDateTime() {
		return paymentOrderDateTime;
	}
	public void setPaymentOrderDateTime(Date paymentOrderDateTime) {
		this.paymentOrderDateTime = paymentOrderDateTime;
	}
	public Date getPaiedDateTime() {
		return paiedDateTime;
	}
	public void setPaiedDateTime(Date paiedDateTime) {
		this.paiedDateTime = paiedDateTime;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public double getAmountsPayable() {
		return amountsPayable;
	}
	public void setAmountsPayable(double amountsPayable) {
		this.amountsPayable = amountsPayable;
	}
	public double getActuallyPaied() {
		return actuallyPaied;
	}
	public void setActuallyPaied(double actuallyPaied) {
		this.actuallyPaied = actuallyPaied;
	}
	public Long getId() {
		return id;
	}
	
}
