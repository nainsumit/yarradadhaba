package com.restaurant.order.service;

import com.restaurant.request.bean.order.place.OrderRequestBean;
import com.restaurant.request.bean.order.track.TrackOrderRequestBean;
import com.restaurant.response.bean.ResponseBean;

public interface IOrderService
{
	public ResponseBean placeOrder(OrderRequestBean data);
	public ResponseBean orderStatus(TrackOrderRequestBean data);
}
