package com.restaurant.order.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.order.bean.CityArea;
import com.restaurant.order.bean.Customer;
import com.restaurant.order.bean.OrderItemDetails;
import com.restaurant.order.bean.Orders;
import com.restaurant.order.dao.IOrderDao;
import com.restaurant.request.bean.order.place.CustomerDetails;
import com.restaurant.request.bean.order.place.OrderItem;
import com.restaurant.request.bean.order.place.OrderRequestBean;
import com.restaurant.request.bean.order.track.TrackOrderRequestBean;
import com.restaurant.response.bean.ResponseBean;
import com.restaurant.response.bean.order.OrderResponseBean;
import com.restaurant.response.bean.order.OrderResponseData;
import com.restaurant.response.bean.track.TrackResponseBean;
import com.restaurant.response.bean.track.TrackResponseData;
import com.restaurant.utility.CoreConstants;

@Service("orderService")
public class OrderService implements IOrderService
{
	@Autowired(required = true)
	private IOrderDao orderDao;

	@Override
	public ResponseBean placeOrder(OrderRequestBean orderRequestBean)
	{
		CustomerDetails customerDetailsBean = orderRequestBean.getCustomerDetails();
		List<OrderItem> orderItemDetails = orderRequestBean.getOrderItems();

		Customer customer = new Customer();
		customer.setAddress(customerDetailsBean.getAddress());
		customer.setCustomerName(customerDetailsBean.getCustomerName());
		customer.setEmail(customerDetailsBean.getEmail());
		customer.setPhone(customerDetailsBean.getPhone());
		customer.setStatus(CoreConstants.TRUE);
		customer.setCreatedOn(new Date());
		customer.setModifiedOn(new Date());

		Orders order = new Orders();
		order.setCustomer(customer);
		order.setOrderStatus(CoreConstants.Order.ORDERSTATUS_PROCESSING);
		order.setOrderType(customerDetailsBean.getOrderType());
		order.setCityAreaId(new CityArea(Integer.parseInt(customerDetailsBean.getCityAreaId())));
		order.setStatus(CoreConstants.TRUE);
		order.setCreatedOn(new Date());
		order.setModifiedOn(new Date());

		OrderItemDetails itemDetail = null;
		Set<OrderItemDetails> orderItemDetailsList = new HashSet<OrderItemDetails>();

		for (OrderItem orderItemDetailsBean : orderItemDetails)
		{
			itemDetail = new OrderItemDetails();
			itemDetail.setItemId(orderDao.getItem(Integer.parseInt(orderItemDetailsBean.getItemId())));
			itemDetail.setItemQuantity(Integer.parseInt(orderItemDetailsBean.getQuantity()));
			itemDetail.setOrderInfo(order);

			orderItemDetailsList.add(itemDetail);
		}

		order.setOrderItemDetailsList(orderItemDetailsList);

		String id = orderDao.placeOrder(order);

		return createPlaceOrderResponse(id != null ? "YARA" + id : null);
	}

	@Override
	public ResponseBean orderStatus(TrackOrderRequestBean data)
	{
		return createTrackOrderResponse(orderDao.orderStatus(Integer.parseInt(data.getOrderId())));
	}

	private ResponseBean createPlaceOrderResponse(final String orderId)
	{
		OrderResponseBean response = new OrderResponseBean();

		if (orderId == null || orderId.equals(""))
		{
			response.setMessage(CoreConstants.NO_DATA_FOUND);
			response.setStatus(CoreConstants.SUCCESS);
		}
		else
		{
			response.setMessage(CoreConstants.GENERIC_SUCCESS_MESSAGE);
			response.setStatus(CoreConstants.SUCCESS);
		}

		OrderResponseData data = new OrderResponseData();
		data.setOrderId(orderId);

		response.setData(data);

		return response;
	}

	private ResponseBean createTrackOrderResponse(final String orderStatus)
	{
		TrackResponseBean response = new TrackResponseBean();

		if (orderStatus == null || orderStatus.equals(""))
		{
			response.setMessage(CoreConstants.NO_DATA_FOUND);
			response.setStatus(CoreConstants.SUCCESS);
		}
		else
		{
			response.setMessage(CoreConstants.GENERIC_SUCCESS_MESSAGE);
			response.setStatus(CoreConstants.SUCCESS);
		}

		TrackResponseData data = new TrackResponseData();
		data.setOrderStatus(orderStatus);

		response.setData(data);

		return response;
	}
}
