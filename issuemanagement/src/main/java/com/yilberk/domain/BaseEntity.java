package com.yilberk.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "created_by", length = 100)
	private String createdBy;
	
	@Column(name = "updateAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date uptadeAt;
	
	@Column(name = "updated_by", length= 250)
	private String uptatedBy;
	
	@Column(name = "status")
	private Boolean status;
	

}
