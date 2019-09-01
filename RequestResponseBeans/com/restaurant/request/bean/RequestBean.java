package com.restaurant.request.bean;

public class RequestBean
{
	protected String entity;
	protected String type;
	protected String action;
	
	public String getEntity()
	{
		return entity;
	}

	public void setEntity(String entity)
	{
		this.entity = entity;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	@Override
	public String toString()
	{
		return "RequestBean [entity=" + entity + ", type=" + type + ", action=" + action + "]";
	}
}
