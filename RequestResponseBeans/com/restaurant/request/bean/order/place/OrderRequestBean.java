package com.restaurant.request.bean.order.place;

import java.util.List;

import com.restaurant.request.bean.RequestBean;
import com.restaurant.utility.ResponseHandlerUtility;

public class OrderRequestBean extends RequestBean
{
	private OrderRequestData data;
	
	public void setData(OrderRequestData data)
	{
		this.data = data;
	}
	
	public CustomerDetails getCustomerDetails()
	{
		return data.getCustomerDetails();
	}
	
	public List<OrderItem> getOrderItems()
	{
		return data.getOrderDetails();
	}
	
	@Override
	public String toString()
	{
		return ResponseHandlerUtility.logResponseJson(this);
	}
}
