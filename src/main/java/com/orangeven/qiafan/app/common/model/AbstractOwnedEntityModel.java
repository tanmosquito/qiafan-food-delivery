package com.orangeven.qiafan.app.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractOwnedEntityModel extends AbstractEntityModel {
	@Column(name = "owner_id")
	private Long ownerId;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
}
