package com.restaurant.order.dao;

import com.restaurant.menu.bean.Item;
import com.restaurant.order.bean.Orders;

public interface IOrderDao
{
	public String placeOrder(Orders order);
	public Item getItem(int id);
	public String orderStatus(int orderId);
}
