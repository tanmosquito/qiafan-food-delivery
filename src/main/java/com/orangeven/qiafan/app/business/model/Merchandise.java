package com.orangeven.qiafan.app.business.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;

import com.orangeven.qiafan.app.common.enumeration.order.MeasureUnit;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
public class Merchandise extends AbstractOwnedEntityModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3755123149821399352L;
	@Id
    @SequenceGenerator(
            name = "merchandise-seq-generator",
            sequenceName = "merchandise_id_seq",
            initialValue = 99,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "merchandise-seq-generator"
    )
    private Long id;
    private String name;
    private String ingredientDescription;
    private MeasureUnit unit;
    private String about;
    //private double price;
    //private long inventory;
    //private double discount;
    private Long businessId;
    private Long merchandiseCategoryId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchandiseId")
    @OrderColumn(name = "inventory")
    private MerchandiseSegment[] segments;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredientDescription() {
		return ingredientDescription;
	}
	public void setIngredientDescription(String ingredientDescription) {
		this.ingredientDescription = ingredientDescription;
	}
	public MeasureUnit getUnit() {
		return unit;
	}
	public void setUnit(MeasureUnit unit) {
		this.unit = unit;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Long getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}
	public Long getMerchandiseCategoryId() {
		return merchandiseCategoryId;
	}
	public void setMerchandiseCategoryId(Long merchandiseCategoryId) {
		this.merchandiseCategoryId = merchandiseCategoryId;
	}
	public MerchandiseSegment[] getSegments() {
		return segments;
	}
	public void setSegments(MerchandiseSegment[] segments) {
		this.segments = segments;
	}
	public static Long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}

}
