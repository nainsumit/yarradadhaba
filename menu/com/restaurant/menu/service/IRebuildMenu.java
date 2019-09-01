package com.restaurant.menu.service;

import java.util.List;
import java.util.Map;

import org.json.me.JSONException;

import com.restaurant.menu.bean.Item;

public interface IRebuildMenu
{
	public Map<String, Object> rebuildMenu(Map<String, List<Item>> menu) throws JSONException;
}
