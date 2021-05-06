package com.orangeven.qiafan.app.deliverer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.orangeven.qiafan.app.common.enumeration.Gender;
import com.orangeven.qiafan.app.common.model.AbstractLoginableEntityModel;

public class Deliverer extends AbstractLoginableEntityModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1963980880205209673L;
	@Id
    @SequenceGenerator(
            name = "deliverer_seq_generator",
            sequenceName = "deliverer_id_seq",
            initialValue = 99,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "deliverer_seq_generator"
    )
    private Long id;
    private String name;
    private String phone;
    private Gender gender;
    private Date birthday;
    private String citizenId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public Long getId() {
		return id;
	}
}
