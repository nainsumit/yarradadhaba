package com.restaurant.menu.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "OTHER_ITEM")
@DiscriminatorValue(CoreConstants.Menu.NA)
public class OtherItem extends Item
{
	private static final long serialVersionUID = 41L;

	@Override
	@Transient
	public String getType()
	{
		return CoreConstants.Menu.NA;
	}
}
