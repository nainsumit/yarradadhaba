package com.restaurant.request.bean.order.track;

import com.restaurant.request.bean.RequestBean;
import com.restaurant.utility.ResponseHandlerUtility;

public class TrackOrderRequestBean extends RequestBean
{
	private TrackOrderRequestData data;
	
	public void setData(TrackOrderRequestData data)
	{
		this.data = data;
	}
	
	public String getOrderId()
	{
		return data.getOrderId();
	}
	
	@Override
	public String toString()
	{
		return ResponseHandlerUtility.logResponseJson(this);
	}
}
