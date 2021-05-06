package com.orangeven.qiafan.app.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class AbstractLoginableEntityModel extends AbstractEntityModel {

	private String account;
    @JsonIgnore
    private String password;
    private String phone;
    @Column(name = "last_successful_login_ip")
	private String lastSuccessfulLoginIp;
    @Column(name = "last_successful_login_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
	private Date lastSuccessfulLoginTimestamp;
    @Column(name = "last_failed_login_ip")
	private String lastFailedLoginIp;
    @Column(name = "last_failed_login_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
	private Date lastFailedLoginTimestamp;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLastSuccessfulLoginIp() {
		return lastSuccessfulLoginIp;
	}
	public void setLastSuccessfulLoginIp(String lastSuccessfulLoginIp) {
		this.lastSuccessfulLoginIp = lastSuccessfulLoginIp;
	}
	public Date getLastSuccessfulLoginTimestamp() {
		return lastSuccessfulLoginTimestamp;
	}
	public void setLastSuccessfulLoginTimestamp(Date lastSuccessfulLoginTimestamp) {
		this.lastSuccessfulLoginTimestamp = lastSuccessfulLoginTimestamp;
	}
	public String getLastFailedLoginIp() {
		return lastFailedLoginIp;
	}
	public void setLastFailedLoginIp(String lastFailedLoginIp) {
		this.lastFailedLoginIp = lastFailedLoginIp;
	}
	public Date getLastFailedLoginTimestamp() {
		return lastFailedLoginTimestamp;
	}
	public void setLastFailedLoginTimestamp(Date lastFailedLoginTimestamp) {
		this.lastFailedLoginTimestamp = lastFailedLoginTimestamp;
	}
	
}
