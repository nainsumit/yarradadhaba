package com.restaurant.response.bean.menu;

import java.util.Map;

import com.restaurant.response.bean.ResponseBean;
import com.restaurant.utility.ResponseHandlerUtility;

public class MenuResponseBean extends ResponseBean
{
	private Map<String, Object> data;

	public MenuResponseBean()
	{
		super();
	}

	public MenuResponseBean(Map<String, Object> data)
	{
		super();
		this.data = data;
	}

	public Map<String, Object> getData()
	{
		return data;
	}

	public void setData(Map<String, Object> data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return ResponseHandlerUtility.logResponseJson(this);
	}
}
