package com.restaurant.response.bean;

import com.restaurant.utility.ResponseHandlerUtility;

public class GenericErrorResponseBean extends ResponseBean
{
	private String data;

	public String getData()
	{
		return data;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return ResponseHandlerUtility.logResponseJson(this);
	}
}
