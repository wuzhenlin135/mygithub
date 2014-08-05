package com.tencent.djcity.util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.graphics.Bitmap;


import com.tencent.djcity.lib.parser.FileParser;
import com.tencent.djcity.util.activity.BaseActivity;
import com.tencent.djcity.util.ajax.Ajax;
import com.tencent.djcity.util.ajax.Cookie;
import com.tencent.djcity.util.ajax.ImageListener;
import com.tencent.djcity.util.ajax.ImageParser;
import com.tencent.djcity.util.ajax.OnErrorListener;
import com.tencent.djcity.util.ajax.OnSuccessListener;
import com.tencent.djcity.util.ajax.Response;
import com.tencent.djcity.util.cache.FileStorage;
import com.tencent.djcity.util.cache.StorageFactory;

public class AjaxUtil {

	protected static Ajax setDefault(Ajax ajax) {

		//压入icson域cookie
		String Url = ajax.getUrl();
		String host = ajax.getHost();
			
		Cookie cookie = ToolUtil.getIcsonCookie();
		ajax.setCookie(cookie);
		
		//?????�头
		ajax.setRequestHeader("Charset", "UTF-8");
		ajax.setRequestHeader("Accept-Encoding", "gzip");
		
		/*
		// Get Host.
		String strHost = ajax.getHost();
		if( !TextUtils.isEmpty(strHost) ){
			ajax.setRequestHeader("Host", strHost);
			
			// Replace the host with ip for testing.
			if( strHost.equalsIgnoreCase("app.51buy.com") 
			 || strHost.equalsIgnoreCase("base.51buy.com")
			 || strHost.equalsIgnoreCase("buy.51buy.com")
			 || strHost.equalsIgnoreCase("item.51buy.com")){
			//	ajax.updateHost(strHost, "10.12.194.122");
				ajax.updateHost(strHost, "10.180.38.132");
			}
		}
		*/

		return ajax;
	}

	/*
	private static Ajax postJSON(String url, HashMap<String, Object> data, JSONListener listener) {
		Ajax ajax = new Ajax(Ajax.POST);
		ajax.setUrl(url);
		ajax.setData(data);
		ajax.setParser(new JSONParser());
		ajax.setAjaxListener(listener);
		setDefault(ajax);
		return ajax;
	} */

	public static Ajax getImage(String url, ImageListener listener) {
		Ajax ajax = new Ajax(Ajax.GET);
		ajax.setUrl(url);
		ajax.setParser(new ImageParser());
		ajax.setAjaxListener(listener);
		return ajax;
	}

	public static void getLocalImage(BaseActivity activity, final String url, final ImageLoadListener listener) {
		final FileStorage mFileStorage = StorageFactory.getFileStorage(activity);
		String fileName = "a" + ToolUtil.getMD5(url);
		String path = null;
		if (fileName != null) {
			path = Config.PIC_CACHE_DIR + "/" + fileName + ToolUtil.getExtension(url) + ".cache";
			Bitmap data = mFileStorage.getImage(path);
			if (data != null) {
				listener.onLoaded(data, url);
				return;
			}
		}

		Ajax ajax = new Ajax(Ajax.GET);
		ajax.setUrl(url);
		ajax.setParser(new ImageParser());

		final String filePath = path;
		ajax.setOnSuccessListener(new OnSuccessListener<Bitmap>() {
			@Override
			public void onSuccess(Bitmap v, Response response) {
				if (filePath != null) {
					if (mFileStorage.createPath(Config.PIC_CACHE_DIR) != null) {
						mFileStorage.saveImage(filePath, v);
					}
				}
				listener.onLoaded(v, url);
			}
		});

		ajax.setOnErrorListener(new OnErrorListener() {
			@Override
			public void onError(Ajax ajax, Response response) {
				if(listener != null ){ listener.onError(url);};
			}
		});
		ajax.send();
		activity.addAjax(ajax);
	}

	public static Ajax getImage(String url) {
		return getImage(url, null);
	}

	public static Ajax get(String url) {
		Ajax ajax = new Ajax(Ajax.GET);
		ajax.setUrl(url, true);
		setDefault(ajax);
		return ajax;
	}

	public static Ajax post(String url) {
		Ajax ajax = new Ajax(Ajax.POST);
		ajax.setUrl(url, true);
		setDefault(ajax);
		return ajax;
	}

	public static Ajax downLoad(String url, String savePath, OnSuccessListener<File> success, OnErrorListener error) {
		Ajax ajax = new Ajax(Ajax.GET);
		ajax.setUrl(url);
		ajax.setParser(new FileParser(savePath));
		ajax.setOnSuccessListener(success);
		ajax.setOnErrorListener(error);
		return ajax;
	}
}
