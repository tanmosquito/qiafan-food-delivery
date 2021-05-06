package com.orangeven.qiafan.app.common.model.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orangeven.qiafan.app.common.enumeration.order.OrderState;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
@Table(name = "customer_delivery_order")
public class Order extends AbstractOwnedEntityModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3105769165909482632L;
	@GeneratedValue(
		generator = "id-sequence-generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
			name = "id-sequence-generator",
			sequenceName = "customer_delivery_order_id_seq",
			initialValue = 99,
			allocationSize = 10
	)
    private Long id;
	@Column(name = "order_id")
    private String orderId;
	@Column(name = "owner_id")
	private Long ownerId;
	@Column(name = "business_id")
	private Long businessId;
    @Enumerated(EnumType.STRING)
    private OrderState state;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "amount_payable")
    private BigDecimal amountPayable;
    @Column(name = "payment_information_id")
    private Long paymentInformationId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderId")
    @OrderColumn
    private OrderFoodItem[] foodItems;
    @Column(name = "message_from_customer")
    private String messageFromCustomer;
    @Column(name = "deliverer_id")
    private Long delivererId;
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "order_datetime")
    private Date orderDatetime;
    @Column(name = "due_duration")
    private Date dueDuration;
    @Column(name = "finished_datetime")
    private Date finishedDatetime;
	
	public Long getId() {
		return id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Long getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setPaymentInformationId(Long paymentInformationId) {
		this.paymentInformationId = paymentInformationId;
	}
	public void setDelivererId(Long delivererId) {
		this.delivererId = delivererId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	public String getMessageFromCustomer() {
		return messageFromCustomer;
	}
	public void setMessageFromCustomer(String messageFromCustomer) {
		this.messageFromCustomer = messageFromCustomer;
	}
	public long getDelivererId() {
		return delivererId;
	}
	public void setDelivererId(long delivererId) {
		this.delivererId = delivererId;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public Date getOrderDatetime() {
		return orderDatetime;
	}
	public void setOrderDatetime(Date orderDatetime) {
		this.orderDatetime = orderDatetime;
	}
	public Date getDueDuration() {
		return dueDuration;
	}
	public void setDueDuration(Date dueDuration) {
		this.dueDuration = dueDuration;
	}
	public Date getFinishedDatetime() {
		return finishedDatetime;
	}
	public void setFinishedDatetime(Date finishedDatetime) {
		this.finishedDatetime = finishedDatetime;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BigDecimal getAmountPayable() {
		return amountPayable;
	}
	public void setAmountPayable(BigDecimal amountPayable) {
		this.amountPayable = amountPayable;
	}
	public long getPaymentInformationId() {
		return paymentInformationId;
	}
	public void setPaymentInformationId(long paymentInformationId) {
		this.paymentInformationId = paymentInformationId;
	}
	public OrderFoodItem[] getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(OrderFoodItem[] foodItems) {
		this.foodItems = foodItems;
	}
    
}
