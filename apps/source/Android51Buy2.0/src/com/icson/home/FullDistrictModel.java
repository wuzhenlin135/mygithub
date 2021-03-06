package com.icson.home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import com.icson.lib.model.BaseModel;
import com.icson.util.ToolUtil;

public class FullDistrictModel extends BaseModel{
	ArrayList<ProvinceModel> mProvnceModels = new ArrayList<ProvinceModel>();
	String strMD5;
	
	public ArrayList<ProvinceModel> getProvinceModels(){
		return mProvnceModels;
	}
	
	public String getMD5Value(){
		return strMD5;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FullDistrictModel parse(JSONObject json) throws JSONException {
		if(null == json) {
			return null;
		}
		
		strMD5 = json.optString("md5", "");
		if(!ToolUtil.isEmptyList(json, "fullDistrict")) {
			JSONObject data = json.getJSONObject("fullDistrict");
			if(null != data) {
				Iterator<String> iter = data.keys();
				while(iter.hasNext()) {
					ProvinceModel model = new ProvinceModel();
					String key = iter.next();
					model.parse(data.getJSONObject(key));
					mProvnceModels.add(model);
				}
				
				Collections.sort(mProvnceModels, new Comparator(){
					@Override
					public int compare(Object one, Object another) {
						ProvinceModel a = (ProvinceModel) one;
						ProvinceModel b = (ProvinceModel) another;
						return ToolUtil.compareInt(a.getProvinceSortId(), b.getProvinceSortId());
					}
				});
			}
		}
		
		return null;
	}

}
