package com.restaurant.response.bean.track;

public class TrackResponseData
{
	private String orderStatus;

	public String getOrderStatus()
	{
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus)
	{
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString()
	{
		return "OrderResponseData [orderId=" + orderStatus + "]";
	}
}
