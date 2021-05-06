package com.orangeven.qiafan.app.business.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orangeven.qiafan.app.common.model.AbstractLoginableEntityModel;

@Entity
@DynamicInsert
public class Business extends AbstractLoginableEntityModel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6005503320809433353L;
	@Id
    @SequenceGenerator(
            name = "business-seq-generator",
            sequenceName = "business_id_seq",
            initialValue = 99,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "business-seq-generator"
    )
    private Long id;
    private String account;
    @JsonIgnore
    private String password;
    @Column(name = "business_name")
    private String businessName;
    private String phone;
    private String telephone;
    private String address;
    @Column(name = "delivery_cost")
    private double deliveryCost;
    @Column(name = "minimum_order")
    private double minimumOrder;
    @Column(name  = "category_id")
    private String categoryId;
    @Column(name = "opening_time")
    @Temporal(TemporalType.TIME)
    private Date openingTime;
    @Column(name = "closing_time")
    @Temporal(TemporalType.TIME)
    private Date closingTime;
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddresses() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public double getMinimumOrder() {
		return minimumOrder;
	}

	public void setMinimumOrder(double minimumOrder) {
		this.minimumOrder = minimumOrder;
	}

}
