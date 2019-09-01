package com.restaurant.user.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "USER", schema = CoreConstants.SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "EMAIL" , "PHONE" }) })
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;

	private Integer userId;

	private String password;

	private String email;

	private String phone;
	
	private String status;

	private Date createdOn;

	private Date modifiedOn;
	
	@Id
	@Column(name = "USER_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	@Column(name = "PASSWORD", nullable = false , length = 20)
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "EMAIL", nullable = false , length = 100)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "PHONE", nullable = false , length = 12)
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(name = "STATUS", nullable = false, length = 5)
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", nullable = false)
	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_ON", nullable = false)
	public Date getModifiedOn()
	{
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn)
	{
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", status=" + status + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}
}
