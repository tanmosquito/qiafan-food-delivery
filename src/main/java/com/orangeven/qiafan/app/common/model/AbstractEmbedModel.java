package com.orangeven.qiafan.app.common.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public abstract class AbstractEmbedModel {
    protected boolean disabled;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "disabled_date_time")
    protected Date disabledDateTime;
    @Column(name = "created_date_time")
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDateTime;
    @Column(name = "last_modified_date_time")
    @Generated(GenerationTime.ALWAYS)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDateTime;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Date getDisabledDateTime() {
        return disabledDateTime;
    }

    public void setDisabledDateTime(Date disabledDateTime) {
        this.disabledDateTime = disabledDateTime;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(Date lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }
}
