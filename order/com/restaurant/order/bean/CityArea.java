package com.restaurant.order.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "CITY_AREA", schema = CoreConstants.SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "CITY_NAME", "AREA_NAME" })})
public class CityArea implements Serializable
{
	private static final long serialVersionUID = 10L;

	private Integer cityAreaId;

	private String cityName;

	private String areaName;
	
	private Set<Orders> orders;
	
	private String status;

	private Date createdOn;

	private Date modifiedOn;

	public CityArea()
	{}
	
	public CityArea(Integer cityAreaId)
	{
		this.cityAreaId = cityAreaId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITY_AREA_ID", nullable = false, unique = true)
	public Integer getCityAreaId()
	{
		return cityAreaId;
	}

	public void setCityAreaId(Integer cityAreaId)
	{
		this.cityAreaId = cityAreaId;
	}

	@Column(name = "CITY_NAME", nullable = false, length = 50)
	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	@Column(name = "AREA_NAME", nullable = false, length = 50)
	public String getAreaName()
	{
		return areaName;
	}

	public void setAreaName(String areaName)
	{
		this.areaName = areaName;
	}

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "cityAreaId")
	public Set<Orders> getOrders()
	{
		return orders;
	}

	public void setOrders(Set<Orders> orders)
	{
		this.orders = orders;
	}
	
	@Column(name = "STATUS", nullable = false , length = 5)
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
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaName == null) ? 0 : areaName.hashCode());
		result = prime * result + ((cityAreaId == null) ? 0 : cityAreaId.hashCode());
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityArea other = (CityArea) obj;
		if (areaName == null)
		{
			if (other.areaName != null)
				return false;
		}
		else if (!areaName.equals(other.areaName))
			return false;
		if (cityAreaId == null)
		{
			if (other.cityAreaId != null)
				return false;
		}
		else if (!cityAreaId.equals(other.cityAreaId))
			return false;
		if (cityName == null)
		{
			if (other.cityName != null)
				return false;
		}
		else if (!cityName.equals(other.cityName))
			return false;
		return true;
	}
}
