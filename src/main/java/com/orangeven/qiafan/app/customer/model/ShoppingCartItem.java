package com.orangeven.qiafan.app.customer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
@Table(name = "customer_shopping_cart")
public class ShoppingCartItem extends AbstractOwnedEntityModel implements Serializable{

	@Id
	private Long id;
	private Long mechandiseId;
	private String merchandiseName;
	private Long merchandiseSegmentId;
	private BigDecimal price;
	private int quantity;
	public long getMechandiseId() {
		return mechandiseId;
	}
	public void setMechandiseId(Long mechandiseId) {
		this.mechandiseId = mechandiseId;
	}
	public String getMerchandiseName() {
		return merchandiseName;
	}
	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}
	public long getMerchandiseSegmentId() {
		return merchandiseSegmentId;
	}
	public void setMerchandiseSegmentId(Long merchandiseSegmentId) {
		this.merchandiseSegmentId = merchandiseSegmentId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6122657189138296564L;
	
}
