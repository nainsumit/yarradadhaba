package com.restaurant.order.dao;

import java.lang.reflect.Method;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.menu.bean.Item;
import com.restaurant.order.bean.OrderItemDetails;
import com.restaurant.order.bean.Orders;

@Repository("orderDao")
public class OrderDao implements IOrderDao
{
	@Autowired
	private SessionFactory sessionFactory;

	private Class params[] = { Session.class };

	@Override
	public String placeOrder(Orders order)
	{
		Session session = null;

		String id = "";

		try
		{
			session = sessionFactory.openSession();

			id = (Integer) session.save(order) + "";

			for (OrderItemDetails orderItemDetails : order.getOrderItemDetailsList())
			{
				session.save(orderItemDetails);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
				session.close();
		}

		return id;
	}

	private String saveOrderToDB(Orders order , Session session)
	{
		String id = "";

		id = (Integer) session.save(order) + "";

		for (OrderItemDetails orderItemDetails : order.getOrderItemDetailsList())
		{
			session.save(orderItemDetails);
		}

		return id;
	}

	@Override
	public String orderStatus(int orderId)
	{
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			return ((Orders) session.get(Orders.class, orderId)).getOrderStatus();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public Item getItem(int id)
	{
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			return ((Item) session.get(Item.class, id));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
				session.close();
		}
		return null;
	}

	private Object process(String methodName)
	{
		Session session = sessionFactory.openSession();

		try
		{
			Class cls = this.getClass();

			Object obj = cls.newInstance();

			Method method = cls.getDeclaredMethod(methodName, params);

			return method.invoke(obj, session);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
				session.close();
		}

		return null;
	}
}
