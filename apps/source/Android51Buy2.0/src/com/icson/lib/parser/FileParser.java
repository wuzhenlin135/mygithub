package com.icson.lib.parser;

import java.io.File;
import java.io.FileOutputStream;

import com.icson.util.Log;
import com.icson.util.ToolUtil;
import com.icson.util.ajax.Parser;

public class FileParser extends Parser<byte[], File> {

	private String mSavePath;
	private static String LOG_TAG = FileParser.class.getName();
	
	public FileParser(String savePath) {
		mSavePath = savePath;
	}

	@Override
	public File parse(byte[] input, String charset) throws Exception {
		if (mSavePath == null)
			return null;

		File file = new File(mSavePath);
		file.createNewFile();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(input);
		} catch (Exception e) {
			Log.e(LOG_TAG, ToolUtil.getStackTraceString(e));
		}finally{
			try {
				if(fos != null)
					fos.close();
					
			} catch (Exception ex) {
				Log.e(LOG_TAG, ToolUtil.getStackTraceString(ex));
			}
		}
		
		return file;
	}
}
