package com.orangeven.qiafan.app.common.model.order;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orangeven.qiafan.app.common.enumeration.order.RefundState;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
@Table(name = "customer_delivery_order_food")
public class OrderFoodItem extends AbstractOwnedEntityModel implements Serializable {
    
	@Id
	@SequenceGenerator(
			name = "order-food-item-id-generator",
			sequenceName = "customer_delivery_order_food_id_seq",
			initialValue = 99,
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "order-food-item-id-generator"
	)
	private long id;
	private long orderId;
    @Column(name = "merchandise_segment_id")
    private long merchandiseSegmentId;
    private int quantity;
    private BigDecimal price;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    @Column(name = "refund_state")
    private RefundState refundState;
    @Column(name = "refund_application_id")
    private long refundApplicationId;

    public RefundState getRefundState() {
		return refundState;
	}

	public void setRefundState(RefundState refundState) {
		this.refundState = refundState;
	}

	public long getRefundApplicationId() {
		return refundApplicationId;
	}

	public void setRefundApplicationId(long refundApplicationId) {
		this.refundApplicationId = refundApplicationId;
	}

	public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getMerchandiseSegmentId() {
        return merchandiseSegmentId;
    }

    public void setMerchandiseSegmentId(long merchandiseSegmentId) {
        this.merchandiseSegmentId = merchandiseSegmentId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -4426220756470791952L;
}
