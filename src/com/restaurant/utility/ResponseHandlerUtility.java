package com.restaurant.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.response.bean.GenericErrorResponseBean;
import com.restaurant.response.bean.ResponseBean;

public class ResponseHandlerUtility
{
	public static String logResponseJson(Object object)
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			return mapper.writeValueAsString(object);
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "";
	}

	public static ResponseBean createErrorResponseBean()
	{
		GenericErrorResponseBean errorResponse = new GenericErrorResponseBean();

		errorResponse.setStatus(CoreConstants.FAILURE);
		errorResponse.setMessage(CoreConstants.GENERIC_ERROR_MESSAGE);
		errorResponse.setData("");

		return errorResponse;
	}
}
