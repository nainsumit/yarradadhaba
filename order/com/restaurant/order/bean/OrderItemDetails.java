package com.restaurant.order.bean;

import java.io.Serializable;

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
import javax.persistence.Table;

import com.restaurant.menu.bean.Item;
import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "ORDER_ITEM_DETAILS", schema = CoreConstants.SCHEMA_NAME)
public class OrderItemDetails implements Serializable
{
	private static final long serialVersionUID = 67L;

	private Integer order_Item_Details_ID;

	private Item itemId;

	private Integer itemQuantity;

	private Orders orderInfo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ITEM_DETAILS_ID", unique = true)
	public Integer getOrder_Item_Details_ID()
	{
		return order_Item_Details_ID;
	}

	public void setOrder_Item_Details_ID(Integer order_Item_Details_ID)
	{
		this.order_Item_Details_ID = order_Item_Details_ID;
	}

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "ITEM_ID",  foreignKey = @ForeignKey(name = "fk_item_orderItemDetail"))
	public Item getItemId()
	{
		return itemId;
	}

	public void setItemId(Item itemId)
	{
		this.itemId = itemId;
	}

	@Column(name = "ITEM_QUANTITY",  length = 2)
	public Integer getItemQuantity()
	{
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity)
	{
		this.itemQuantity = itemQuantity;
	}

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID", nullable = false , foreignKey = @ForeignKey(name = "fk_order_orderItemDetail"))
	public Orders getOrderInfo()
	{
		return orderInfo;
	}

	public void setOrderInfo(Orders orderInfo)
	{
		this.orderInfo = orderInfo;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemQuantity == null) ? 0 : itemQuantity.hashCode());
		result = prime * result + ((orderInfo == null) ? 0 : orderInfo.hashCode());
		result = prime * result + ((order_Item_Details_ID == null) ? 0 : order_Item_Details_ID.hashCode());
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
		OrderItemDetails other = (OrderItemDetails) obj;
		if (itemId == null)
		{
			if (other.itemId != null)
				return false;
		}
		else if (!itemId.equals(other.itemId))
			return false;
		if (itemQuantity == null)
		{
			if (other.itemQuantity != null)
				return false;
		}
		else if (!itemQuantity.equals(other.itemQuantity))
			return false;
		if (orderInfo == null)
		{
			if (other.orderInfo != null)
				return false;
		}
		else if (!orderInfo.equals(other.orderInfo))
			return false;
		if (order_Item_Details_ID == null)
		{
			if (other.order_Item_Details_ID != null)
				return false;
		}
		else if (!order_Item_Details_ID.equals(other.order_Item_Details_ID))
			return false;
		return true;
	}
}
