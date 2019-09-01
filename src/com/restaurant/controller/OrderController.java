package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restaurant.order.service.IOrderService;
import com.restaurant.request.bean.order.place.OrderRequestBean;
import com.restaurant.request.bean.order.track.TrackOrderRequestBean;
import com.restaurant.response.bean.ResponseBean;
import com.restaurant.utility.ResponseHandlerUtility;

@Controller
@RequestMapping(value = "/order")
public class OrderController
{
	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/placeOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean placeOrder(@RequestBody OrderRequestBean orderRequestBean)
	{		
		try
		{	
			return orderService.placeOrder(orderRequestBean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseHandlerUtility.createErrorResponseBean();
		}
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/trackOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean trackOrder(@RequestBody TrackOrderRequestBean trackOrderRequestBean)
	{
		try
		{	
			return orderService.orderStatus(trackOrderRequestBean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseHandlerUtility.createErrorResponseBean();
		}
	}
}
