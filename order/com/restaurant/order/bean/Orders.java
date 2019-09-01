package com.restaurant.order.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "ORDERS", schema = CoreConstants.SCHEMA_NAME)
public class Orders implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer orderID;

	private Customer customer;

	private String orderStatus;

	private CityArea cityAreaId;

	private String orderType;

	private Set<OrderItemDetails> orderItemDetailsList;

	private String status;

	private Date createdOn;

	private Date modifiedOn;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID", unique = true, nullable = false)
	public Integer getOrderID()
	{
		return orderID;
	}

	public void setOrderID(Integer orderID)
	{
		this.orderID = orderID;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false, foreignKey = @ForeignKey(name = "fk_order_customer"))
	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	@Column(name = "ORDER_STATUS", unique = false, nullable = false, length = 20)
	public String getOrderStatus()
	{
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus)
	{
		this.orderStatus = orderStatus;
	}

	@Column(name = "ORDER_TYPE", nullable = false, length = 20)
	public String getOrderType()
	{
		return orderType;
	}

	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "CITY_AREA_ID", nullable = false, foreignKey = @ForeignKey(name = "fk_order_cityAreaId"))
	public CityArea getCityAreaId()
	{
		return cityAreaId;
	}

	public void setCityAreaId(CityArea cityAreaId)
	{
		this.cityAreaId = cityAreaId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderInfo")
	public Set<OrderItemDetails> getOrderItemDetailsList()
	{
		return orderItemDetailsList;
	}

	public void setOrderItemDetailsList(Set<OrderItemDetails> orderItemDetailsList)
	{
		this.orderItemDetailsList = orderItemDetailsList;
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
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityAreaId == null) ? 0 : cityAreaId.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((orderType == null) ? 0 : orderType.hashCode());
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
		Orders other = (Orders) obj;
		if (cityAreaId == null)
		{
			if (other.cityAreaId != null)
				return false;
		}
		else if (!cityAreaId.equals(other.cityAreaId))
			return false;
		if (customer == null)
		{
			if (other.customer != null)
				return false;
		}
		else if (!customer.equals(other.customer))
			return false;
		if (orderID == null)
		{
			if (other.orderID != null)
				return false;
		}
		else if (!orderID.equals(other.orderID))
			return false;
		if (orderStatus == null)
		{
			if (other.orderStatus != null)
				return false;
		}
		else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (orderType == null)
		{
			if (other.orderType != null)
				return false;
		}
		else if (!orderType.equals(other.orderType))
			return false;
		return true;
	}
}
