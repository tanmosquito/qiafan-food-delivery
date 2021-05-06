package com.orangeven.qiafan.app.business.model;

import com.orangeven.qiafan.app.common.model.AbstractEntityModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MerchandiseSegment extends AbstractEntityModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1050213521196515156L;
	@Id
    @SequenceGenerator(
            name = "merchandise-segment-generator",
            sequenceName = "merchandise_segment_id_seq",
            initialValue = 99,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "merchandise-segment-generator"
    )
    private Long id;
	@Column(name = "is_subject")
    private boolean isSubject;
	@Column(name = "mechandise_id")
    private Long merchandiseId;
	@Column(name = "merchandise_segment_name")
    private String merchandiseSegmentName;
    private double price;
    private long inventory;
    private double discount;
	public boolean isSubject() {
		return isSubject;
	}
	public void setSubject(boolean isSubject) {
		this.isSubject = isSubject;
	}
	public Long getMerchandiseId() {
		return merchandiseId;
	}
	public void setMerchandiseId(Long merchandiseId) {
		this.merchandiseId = merchandiseId;
	}
	public String getMerchandiseSegmentName() {
		return merchandiseSegmentName;
	}
	public void setMerchandiseSegmentName(String merchandiseSegmentName) {
		this.merchandiseSegmentName = merchandiseSegmentName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getInventory() {
		return inventory;
	}
	public void setInventory(long inventory) {
		this.inventory = inventory;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Long getId() {
		return id;
	}
    
}
