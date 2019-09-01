package com.restaurant.utility;

public interface CoreConstants
{
	//String SCHEMA_NAME = "YARADADHABA";

	//test
	String SCHEMA_NAME = "infosys";

	String FAILURE = "FAILURE";

	String SUCCESS = "SUCCESS";

	String GENERIC_ERROR_MESSAGE = "some Error Has Occured, Please Try After Sometime";

	String GENERIC_SUCCESS_MESSAGE = "Transaction Complete Successfully";

	String DATA_ISSUE = "Data Issue";

	String NO_DATA_FOUND = "No Data Found";
	
	String TRUE = "TRUE";
	
	String FALSE = "FALSE";
	
	String STARTS = "-----------Starts-----------";
	
	String ENDS = "-----------Ends-----------";

	public interface Customer
	{
		String CUTOMERDETAILS = "customerDetails";

		String CUSTOMERNAME = "customerName";

		String PHONE = "phone";

		String EMAIL = "email";

		String ADDRESS = "address";

		String CITYAREAID = "cityAreaId";

		String ORDERTYPE = "orderType";
	}

	public interface Order
	{
		String ORDERDETAILS = "orderDetails";

		String ITEMID = "itemId";

		String ITEMNAME = "itemName";

		String QUANTITY = "quantity";

		String ORDERSTATUS_PROCESSING = "PROCESSING";

		String ORDERID = "orderId";
	}

	public interface Menu
	{
		String NAME = "name";

		String ITEM_ID = "itemId";

		String PRICE = "price";

		String VEG = "veg";

		String NON_VEG = "nonveg";

		String NA = "NA";
		
		String MENU_FETCHED_SUCCESSFULLY = "Menu Fetched Successfully";
	}
}
