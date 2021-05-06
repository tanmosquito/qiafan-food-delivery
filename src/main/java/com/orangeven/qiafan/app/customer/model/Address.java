package com.orangeven.qiafan.app.customer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
@Table(name = "customer_address")
public class Address extends AbstractOwnedEntityModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6263554164035728584L;
	@Id
    @SequenceGenerator(
            name = "customer_address_seq_generator",
            sequenceName = "customer_address_id_seq",
            initialValue = 99,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_address_seq_generator"
    )
    private Long id;
	@Column(name = "owner_id")
    private Long ownerId;
	@Column(name = "country_id")
    private String countryId;
	@Column(name = "province_id")
    private String provinceId;
	@Column(name = "city_id")
    private String cityId;
	@Column(name = "district_id")
    private String districtId;
	@Column(name = "street_id")
    private String streetId;
	@Column(name = "remain_address")
    private String remainAddress;
	@Column(name  = "zip_code")
	private String zipCode;
    private String tag;
    @Column(name = "is_default")
    private boolean isDefaultAddress;
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getStreetId() {
		return streetId;
	}
	public void setStreetId(String streetId) {
		this.streetId = streetId;
	}
	public String getRemainAddress() {
		return remainAddress;
	}
	public void setRemainAddress(String remainAddress) {
		this.remainAddress = remainAddress;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public boolean isDefaultAddress() {
		return isDefaultAddress;
	}
	public void setDefaultAddress(boolean isDefaultAddress) {
		this.isDefaultAddress = isDefaultAddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
    
}
