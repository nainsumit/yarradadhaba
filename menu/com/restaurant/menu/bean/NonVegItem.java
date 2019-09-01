package com.restaurant.menu.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.restaurant.utility.CoreConstants;

@Entity
@Table(name = "NONVEG_ITEM")
@DiscriminatorValue(CoreConstants.Menu.NON_VEG)
public class NonVegItem extends Item
{
	private static final long serialVersionUID = 32L;

	@Override
	@Transient
	public String getType()
	{
		return CoreConstants.Menu.NON_VEG;
	}
}
