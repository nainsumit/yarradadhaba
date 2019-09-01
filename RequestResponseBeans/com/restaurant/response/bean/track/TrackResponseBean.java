package com.restaurant.response.bean.track;

import com.restaurant.response.bean.ResponseBean;
import com.restaurant.utility.ResponseHandlerUtility;

public class TrackResponseBean extends ResponseBean
{
	TrackResponseData data;

	public TrackResponseData getData()
	{
		return data;
	}

	public void setData(TrackResponseData data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return ResponseHandlerUtility.logResponseJson(this);
	}
}
