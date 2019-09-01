package com.restaurant.menu.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "VEG_ITEM")
@DiscriminatorValue(CoreConstants.Menu.VEG)
public class VegItem extends Item
{
	private static final long serialVersionUID = 78L;

	@Override
	@Transient
	public String getType()
	{
		return CoreConstants.Menu.VEG;
	}
}
