package com.orangeven.qiafan.app.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;

@Entity
@Table(name = "business_category")
public class BusinessCategory extends AbstractOwnedEntityModel {
	@Id
	private long id;
    private String name;
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
