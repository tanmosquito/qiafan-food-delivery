package com.orangeven.qiafan.app.administrator.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.orangeven.qiafan.app.common.model.AbstractLoginableEntityModel;

public class Administrator extends AbstractLoginableEntityModel {
	@Id
	@SequenceGenerator(
			name = "administrator-id-generator",
			sequenceName = "administrator_id_seq",
			initialValue = 99,
			allocationSize = 1
	)
	@GeneratedValue(
			generator = "administrator-id-generator",
			strategy = GenerationType.SEQUENCE
	)
	private Long id;
	private String email;
	private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	
}
