package com.restaurant.menu.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.restaurant.menu.bean.Item;

public interface IMenuDao
{
	public Map<String, List<Item>> fetchCategoryWiseMenu() throws SQLException;
}
