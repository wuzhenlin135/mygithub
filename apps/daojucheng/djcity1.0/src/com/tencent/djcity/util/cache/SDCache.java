package com.tencent.djcity.util.cache;

import java.io.File;

import android.os.Environment;

import com.tencent.djcity.util.Config;
import com.tencent.djcity.util.Log;
import com.tencent.djcity.util.ToolUtil;

public class SDCache extends FileStorage {

	private final String LOG_TAG = SDCache.class.getName();

	private String mRoot;

	/**
	 * 该�???????��?��?????�???��??sd card??????�????�?�????�?�???��????��??�????�???��?��??常�??�????�????�???��?????sd card??????�?�????建�??�????�?Config.TMPDIRNAME???
	 */
	public SDCache() {
		if (!ToolUtil.isSDExists()) {
			RuntimeException ex = new RuntimeException("sd card is not exists.");
			Log.e(LOG_TAG, ex);
			throw ex;
		}

		mRoot = Environment.getExternalStorageDirectory() + "/" + Config.TMPDIRNAME;

		File file = new File(mRoot);

		if (!file.exists()) {
			file.mkdir();
		}
	}

	@Override
	public String getRootPath() {
		return mRoot + "/";
	}
}
