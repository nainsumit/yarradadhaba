package com.restaurant.menu.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.me.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.menu.bean.Item;
import com.restaurant.menu.dao.IMenuDao;
import com.restaurant.response.bean.ResponseBean;
import com.restaurant.response.bean.menu.MenuResponseBean;
import com.restaurant.utility.CoreConstants;

@Service("menuService")
public class MenuService implements IMenuService
{
	@Autowired
	private IMenuDao menuDao;

	@Autowired
	private IRebuildMenu typeWiseMenu;

	@Override
	public ResponseBean fetchMenu() throws SQLException, JSONException
	{		
		Map<String, List<Item>> menu = menuDao.fetchCategoryWiseMenu();

		Map<String, Object> finalMenu = typeWiseMenu.rebuildMenu(menu);

		return createResponse(finalMenu != null ? finalMenu : null);
	}
	
	private ResponseBean createResponse(Map<String, Object> finalMenu)
	{
		MenuResponseBean bean = new MenuResponseBean();
		bean.setStatus(CoreConstants.SUCCESS);
		bean.setMessage(CoreConstants.Menu.MENU_FETCHED_SUCCESSFULLY);
		bean.setData(finalMenu);
		
		return bean;
	}
}
