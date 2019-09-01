package com.restaurant.request.bean.order.place;

public class OrderItem
{
	private String itemId;
	private String itemName;
	private String quantity;
	
	public String getItemId()
	{
		return itemId;
	}
	public void setItemId(String itemId)
	{
		this.itemId = itemId;
	}
	public String getItemName()
	{
		return itemName;
	}
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	public String getQuantity()
	{
		return quantity;
	}
	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (itemId == null)
		{
			if (other.itemId != null)
				return false;
		}
		else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null)
		{
			if (other.itemName != null)
				return false;
		}
		else if (!itemName.equals(other.itemName))
			return false;
		if (quantity == null)
		{
			if (other.quantity != null)
				return false;
		}
		else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
}
