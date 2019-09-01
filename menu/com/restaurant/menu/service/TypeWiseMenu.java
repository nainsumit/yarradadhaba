package com.restaurant.menu.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.restaurant.menu.bean.Item;
import com.restaurant.utility.CoreConstants;

@Component("typeWiseMenu")
public class TypeWiseMenu implements IRebuildMenu
{
	private Map<String, Object> finalMenu = new LinkedHashMap<String, Object>();

	@Override
	public Map<String, Object> rebuildMenu(Map<String, List<Item>> menu)
	{
		Iterator<Entry<String, List<Item>>> categoryWiseItemListIterator = menu.entrySet().iterator();

		while (categoryWiseItemListIterator.hasNext())
		{
			new CategoryWiseMenuGenerator().buildMenu(categoryWiseItemListIterator.next());
		}

		return finalMenu;
	}

	private class CategoryWiseMenuGenerator
	{
		private Map<String, List<Item>> combinedCategoryWise_Veg_NonVegItems;

		private List<Item> categoryWiseListOfItemsHavingNoType;

		private List<Item> categoryWiseVegItems;

		private List<Item> categoryWiseNonVegItems;

		public CategoryWiseMenuGenerator()
		{
			combinedCategoryWise_Veg_NonVegItems = new LinkedHashMap<String, List<Item>>();

			categoryWiseListOfItemsHavingNoType = new ArrayList<Item>();

			categoryWiseVegItems = new ArrayList<Item>();

			categoryWiseNonVegItems = new ArrayList<Item>();
		}

		public void buildMenu(Entry<String, List<Item>> singleCategory)
		{
			List<Item> itemListPerCategory = singleCategory.getValue();

			seperate_Veg_NonVeg_ItemsPerCategory(itemListPerCategory);

			populateCombinedCategoryWise_Veg_NonVegItemsMap();

			populateFinalCategoryWiseMenuList(singleCategory.getKey());
		}

		private void seperate_Veg_NonVeg_ItemsPerCategory(final List<Item> items)
		{
			for (Item item : items)
			{
				segregateItemsPerType(item);
			}
		}

		private void segregateItemsPerType(Item item)
		{			
			if (item.getType().equals(CoreConstants.Menu.NA))
			{
				categoryWiseListOfItemsHavingNoType.add(item);
			}
			else if (item.getType().equalsIgnoreCase(CoreConstants.Menu.VEG))
			{
				categoryWiseVegItems.add(item);
			}
			else if (item.getType().equalsIgnoreCase(CoreConstants.Menu.NON_VEG))
			{
				categoryWiseNonVegItems.add(item);
			}
		}

		private void populateCombinedCategoryWise_Veg_NonVegItemsMap()
		{
			combinedCategoryWise_Veg_NonVegItems.put(CoreConstants.Menu.NON_VEG, categoryWiseNonVegItems);

			combinedCategoryWise_Veg_NonVegItems.put(CoreConstants.Menu.VEG, categoryWiseVegItems);
		}

		/**
		 * 1) If one item has NA type in category then all items must have NA type
		 * 2) Single category can have both veg - nonveg type.
		 */
		private void populateFinalCategoryWiseMenuList(String category)
		{
			if (!combinedCategoryWise_Veg_NonVegItems.isEmpty())
				finalMenu.put(category, combinedCategoryWise_Veg_NonVegItems);
			if (!categoryWiseListOfItemsHavingNoType.isEmpty())
				finalMenu.put(category, categoryWiseListOfItemsHavingNoType);
		}
	}
}