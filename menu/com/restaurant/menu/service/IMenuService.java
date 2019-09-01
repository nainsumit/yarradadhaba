package com.restaurant.menu.service;

import java.sql.SQLException;

import org.json.me.JSONException;

import com.restaurant.response.bean.ResponseBean;

public interface IMenuService
{
	public ResponseBean fetchMenu() throws SQLException, JSONException;
}
