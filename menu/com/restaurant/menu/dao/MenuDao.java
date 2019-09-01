package com.restaurant.menu.dao;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.menu.bean.Category;
import com.restaurant.menu.bean.Item;
import com.restaurant.utility.CoreConstants;

@Repository("menuDao")
public class MenuDao implements IMenuDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	private Class params[] = { Session.class };

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<Item>> fetchCategoryWiseMenu() throws SQLException
	{

		Object categoryWiseMenu = process("callDataBase_ExtractItems");

		if (categoryWiseMenu instanceof Map)
		{
			return (Map<String, List<Item>>) categoryWiseMenu;
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object process(String methodName)
	{
		Session session = sessionFactory.openSession();

		try
		{
			Class cls = this.getClass();

			Object obj = cls.newInstance();

			Method method = cls.getDeclaredMethod(methodName, params);

			return method.invoke(obj, new Object[] { session });
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

	@SuppressWarnings({ "unused", "unchecked" })
	private Map<String, List<Item>> callDataBase_ExtractItems(Session session) throws SQLException
	{

		Criteria c = session.createCriteria(Item.class).add(Restrictions.eq("status", CoreConstants.TRUE));

		c.addOrder(Order.asc("category"));

		/**
		 * This will do lazy fetching, then prepare a CategoryWiseItems Map
		 */
		return seperateCategoryWiseItems(c.list());

	}

	private Map<String, List<Item>> seperateCategoryWiseItems(List<Item> list)
	{
		System.out.println(list);

		Map<String, List<Item>> categoryWiseItemMap = new LinkedHashMap<String, List<Item>>();

		String categoryName = "";

		List<Item> categoryWiselist = new ArrayList<Item>();

		for (Item item : list)
		{
			Category category = item.getCategory();

			if (!(categoryName.equals("") || categoryName.equals(category.getCategoryName())))
			{
				categoryWiselist = new ArrayList<Item>();
			}

			categoryWiselist.add(item);
			categoryWiseItemMap.put(category.getCategoryName(), categoryWiselist);

			categoryName = category.getCategoryName();
		}

		return categoryWiseItemMap;
	}
}
