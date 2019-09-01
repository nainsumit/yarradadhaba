package com.restaurant.response.bean.order;

import com.restaurant.response.bean.ResponseBean;
import com.restaurant.utility.ResponseHandlerUtility;

public class OrderResponseBean extends ResponseBean
{
	OrderResponseData data;

	public OrderResponseData getData()
	{
		return data;
	}

	public void setData(OrderResponseData data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return ResponseHandlerUtility.logResponseJson(this);
	}
}
