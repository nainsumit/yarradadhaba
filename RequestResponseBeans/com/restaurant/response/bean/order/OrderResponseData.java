package com.restaurant.response.bean.order;

public class OrderResponseData
{
	private String orderId;

	public String getOrderId()
	{
		return orderId;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	@Override
	public String toString()
	{
		return "OrderResponseData [orderId=" + orderId + "]";
	}
}
