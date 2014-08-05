package com.tencent.djcity.search;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tencent.djcity.util.Config;
import com.tencent.djcity.util.Log;
import com.tencent.djcity.util.ToolUtil;
import com.tencent.djcity.util.ajax.JSONParser;
import com.tencent.djcity.util.ajax.Parser;

public class SearchSuggestParser extends Parser<byte[], SmartBoxModel> {

	private static final String LOG_TAG = SearchSuggestParser.class.getName();
	
	@Override
	public SmartBoxModel parse(byte[] input, String charset) throws Exception {
		SmartBoxModel models = new SmartBoxModel();
		
		try {
			JSONParser parser = new JSONParser();
			JSONObject json = parser.parse(input, charset);
			
			if (json.getInt("errno") != 0) {
				mErrMsg = json.optString("data", Config.NORMAL_ERROR);
				return null;
			}

			final String key = "data";
			
			if (json.has(key) && !ToolUtil.isEmptyList(json, key))
			{
				JSONObject dataObject = json.getJSONObject(key);
				
				if(dataObject.has("words"))
				{
					if(!ToolUtil.isEmptyList(dataObject, "words"))
					{
						JSONArray arrs = dataObject.getJSONArray("words");
						
						ArrayList<AutoCompleteModel> autoModels = new ArrayList<AutoCompleteModel>();
						for (int i = 0, len = arrs.length(); i < len; i++) {
							AutoCompleteModel model = new AutoCompleteModel();
							model.parse(arrs.getJSONArray(i));
							autoModels.add(model);
						}
						models.setAutoCompleteModels(autoModels);
					}
				}
				
				if(dataObject.has("cat"))
				{
					if(!ToolUtil.isEmptyList(dataObject, "cat"))
					{
						JSONArray arrs = dataObject.getJSONArray("cat");
						
						int counts = arrs.length();
						if(counts >= 1)
						{
							AutoCompleteCatModel model = new AutoCompleteCatModel();
							model.parse(arrs.getJSONArray(0));
							models.setAutoCompleteCatModel(model);
						}
					}
				}
			}
				
		} catch (Exception ex) {
			Log.e(LOG_TAG, ex);
		}

		return models;
	}
}
