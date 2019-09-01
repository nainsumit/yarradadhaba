package com.restaurant.utility;

import com.utility.json.parser.JSONParser;

public class JSONPayloadExtractor
{
	public static String extract(String jsonPayload, String key)
	{
		if (null == jsonPayload)
		{
			return null;
		}

		if (null == key)
		{
			return null;
		}

		JSONParser jsonParser = new JSONParser();

		jsonParser.setJson(jsonPayload);

		return jsonParser.getValue(key);
	}
}
