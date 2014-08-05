/**
 * Copyright (C) 2012 Tencent Inc.
 * All rights reserved, for internal usage only.
 * 
 * Project: SosoClient
 * FileName: Preference.java
 * 
 * Description: 
 * Author: lorenchen (lorenchen@tencent.com)
 * Created: Oct 30, 2012
 */
package com.icson.preference;

import com.amap.api.maps.model.LatLng;
import com.icson.util.IcsonApplication;

import android.content.Context;
import android.content.SharedPreferences;

public final class Preference 
{
	// Public
	public static final int MODE_NOIMAGE  = 0;
	public static final int MODE_HASIMAGE = 1;
	
	
	public static final int NEED_ACCESS = 0;
	public static final int ACCESSED	= 1;

	/**
	* method Name:getInstance    
	* method Description:  
	* @param aContext
	* @return   
	* Preference  
	* @exception   
	* @since  1.0.0
	 */
	public synchronized static Preference getInstance()
	{
		if( null == mSelf )
		{
			mSelf = new Preference();
			mSelf.setContext(IcsonApplication.app);
		}
		
		return mSelf;
	}
	
	/**
	 * getImageMode
	 * @return
	 */
	public int getImageMode()
	{
		return this.getValue(PREF_IMAGE_MODE);
	}
	
	public void setConfigTag(String strTag) {
		this.setValue(PREF_CONFIG_TIMETAG, strTag);
	}
	
	public String getConfigTag() {
		return this.getString(PREF_CONFIG_TIMETAG);
	}
	
	/**
	 * Check whether push message is enabled.
	 * @return
	 */
	public boolean pushMessageEnabled() {
		return 1 == this.getValue(PREF_PUSH_MESSAGE);
	}
	
	public void setPushMessageEnabled(boolean bEnable) {
		this.setValue(PREF_PUSH_MESSAGE, bEnable ? 1 : 0);
	}
	
	/**
	 * setImageMode
	 * @param nMode
	 */
	public void setAnnounceID(int announce_id)
	{
		this.setValue(PREF_ANNOUNCE_ID, announce_id);
	}
	
	public int getAnnounceID()
	{
		return this.getValue(PREF_ANNOUNCE_ID);
	}
	
	public void addOpenCount()
	{
		this.setValue(PREF_OPEN_COUNT, getOpenCount()+1);
	}
	
	public int getOpenCount()
	{
		return this.getValue(PREF_OPEN_COUNT);
	}
	
	/**
	 * setImageMode
	 * @param nMode
	 */
	public void setImageMode(int nMode)
	{
		this.setValue(PREF_IMAGE_MODE, nMode);
	}
	
	public void setPushInterval(int nMinutes) {
		if( nMinutes > 0 ) {
			this.setValue(PREF_PUSH_INTERVAL, nMinutes);
		}
	}
	
	public int getPushInterval() {
		return this.getValue(PREF_PUSH_INTERVAL);
	}

	/**
	 * 
	* method Name:getPortalVersion    
	* method Description:  
	* @return   
	* int  
	* @exception   
	* @since  1.0.0
	 */
	public String getPortalInfo()
	{
		return getString(PREF_PORTAL_INFO);
	}
	
	
	public void setPortalInfo(String aInfo)
	{
		this.setValue(PREF_PORTAL_INFO, aInfo);
	}
	
	public void setMapLastCenter(LatLng aCt)
	{
		String strInfo = "" + aCt.latitude + "," + aCt.longitude;
		setValue(PREF_MAP_LASTCENTER, strInfo);
	}

	
	public LatLng getMapLastCenter()
	{
		String strInfo = getString(PREF_MAP_LASTCENTER);
		String items [] = strInfo.split(",");
		if(items.length < 2)
			return null;
		LatLng aLL =  new LatLng(Double.valueOf(items[0]), Double.valueOf(items[1]));
		
		return aLL;
		
	}
	
	
	/**
	 * 
	* method Name:setLocalSlotInfo    
	* method Description:  
	* @param aInfo   "2:1" (2 chance remain; 1 expvalue) 
	* void  
	* @exception   
	* @since  1.0.0
	 */
	public void setSlotChanceExp(String aInfo)
	{
		this.setValue(PREF_SLOT_CHANCE_EXP, aInfo);
	}
	public String getSlotChanceExp()
	{
		return getString(PREF_SLOT_CHANCE_EXP);
	}
	
	
	/**
	 * 
	* method Name:setSlotVersion    
	* method Description:  
	* @param aVersion   
	* void  
	* @exception   
	* @since  1.0.0
	 */
	public void setSlotVersion(String aVersion)
	{
		this.setValue(PREF_SLOT_VERSION, aVersion);
	}
	public String getSlotVersion()
	{
		return getString(PREF_SLOT_VERSION);
	}
	
	public void setShakeRange(float aRange)
	{
		setValue(PREF_SHAKE_RANGE, aRange);
	}
	public float getShakeRange()
	{
		return getFloat(PREF_SHAKE_RANGE);
	}
	
	/**
	 * 
	* method Name:setProjVersion    
	* method Description:  
	* @param aVersion   
	* void  
	* @exception   
	* @since  1.0.0
	 */
	public void setProjVersion(int aVersion)
	{
		this.setValue(PREF_PROJ_VERSION, aVersion);
	}
	
	public int getProjVersion()
	{
		return getValue(PREF_PROJ_VERSION);
	}
	
	public void setFirstSightVersion(int idx, int aVersion)
	{
		String []items = getString(PREF_FIRST_SIGHT).split(":");
		if(null == items || idx < 0 || items.length <= idx)
		{
			items = DEFAULT_FIRST_SIGHT.split(":");
		}
		
		items[idx] = ""+aVersion;
		String aTmp = "";
		for(int i = 0; i < items.length;i++)
		{
			aTmp = aTmp + items[i] + ":";
		}
		aTmp = aTmp.substring(0,aTmp.length()-1);
		this.setValue(PREF_FIRST_SIGHT, aTmp);
	}
	
	public int getFirstSightVersion(int idx)
	{
		String []items = getString(PREF_FIRST_SIGHT).split(":");
		if(null == items || idx < 0 || items.length <= idx)
			return 0;
		return Integer.valueOf(items[idx]);
		
	}
	
	public void setUserGuideOfIndex(int idx, int val)
	{
		String []items = getString(PREF_USER_GUIDE).split(":");
		if(null == items || idx < 0 ||  items.length <= idx)
		{
			items = DEFAULT_USER_GUIDE.split(":");
		}
		
		items[idx] = ""+val;
		String aTmp = "";
		for(int i = 0; i < items.length;i++)
		{
			aTmp = aTmp + items[i] + ":";
		}
		aTmp = aTmp.substring(0,aTmp.length()-1);
		this.setValue(PREF_USER_GUIDE, aTmp);
	}
	
	public int getUserGuideOfIndex(int idx)
	{
		String []items = getString(PREF_USER_GUIDE).split(":");
		if(null == items || idx < 0 || items.length <= idx)
			return 0;
		return Integer.valueOf(items[idx]);
	}
	
	/**
	 * 
	* method Name:setQQAccount,setYiXunAccount    
	* method Description:  
	* @param aVersion   
	* void  
	* @exception   
	* @since  2.0.2
	 */
	public void setQQAccount(String account)
	{
		this.setValue(PREF_QQ_ACCOUNT, account);
	}
	public String getQQAccount()
	{
		return getString(PREF_QQ_ACCOUNT);
	}
	public void setLastUID(String last_uid)
	{
		this.setValue(PREF_LAST_UID, last_uid);
	}
	public long getLastUID()
	{
		String lastuid = getString(PREF_LAST_UID);
		long uid;
		uid = lastuid.equals("")? 0 : Long.valueOf(lastuid);
		return uid;
	}
	public void setYiXunAccount(String account)
	{
		this.setValue(PREF_YIXUN_ACCOUNT, account);
	}
	public String getYiXunAccount()
	{
		return getString(PREF_YIXUN_ACCOUNT);
	}
	
	public void setBarcodeAccess(int accessValue)
	{
		this.setValue(PREF_BARCODE_ACESS, accessValue);
	}
	public Boolean needToBarcodeAccess()
	{
		return NEED_ACCESS == getValue(PREF_BARCODE_ACESS)? true : false;
	}
	
	public void setContactAccess(int accessValue)
	{
		this.setValue(PREF_CONTACT_ACESS, accessValue);
	}
	public Boolean needToContactAccess()
	{
		return NEED_ACCESS == getValue(PREF_CONTACT_ACESS)? true : false;
	}
	
	public void setHONOR3Access(int accessValue)
	{
		this.setValue(PREF_HONOR3_ACESS, accessValue);
	}
	public Boolean needToHONOR3Access()
	{
		return NEED_ACCESS == getValue(PREF_HONOR3_ACESS)? true : false;
	}
	
	public void setMapAccess(int accessValue)
	{
		this.setValue(PREF_MAP_ACESS, accessValue);
	}
	public Boolean needToMapAccess()
	{
		return NEED_ACCESS == getValue(PREF_MAP_ACESS)? true : false;
	}
	
	public void setCallAccess(int accessValue)
	{
		this.setValue(PREF_CALL_ACESS, accessValue);
	}
	public Boolean needCallAccess()
	{
		return NEED_ACCESS == getValue(PREF_CALL_ACESS)? true : false;
	}
	
	/**
	* method Name:restoreDefault    
	* method Description:  
	* void  
	* @exception   
	* @since  1.0.0
	 */
	public void restoreDefault()
	{
		if ( null == mValMap )
			return ;
		
		for(int nIndex = 0; nIndex < MUTABLE_SIZE; nIndex++)
		{
			mValMap.setValue(PROPERTIES[nIndex], DEFAULTS[nIndex]);
		}
	}
	
	/**
	 * savePreference
	 * Save preference
	 */
	public void savePreference()
	{
		if ( null != mPreferences )
		{
			// Save the items to local preference.
			final int nSize = (null != mValMap ? mValMap.size() : 0);
			if ( nSize > 0 )
			{
				SharedPreferences.Editor pEditor = mPreferences.edit();
				
				for ( int nIdx = 0; nIdx < nSize; nIdx++ )
				{
					ValueMap.Element pElement = mValMap.elementAt(nIdx);
					
					if( null != pElement )
					{
						// Save to local storage.
						pEditor.putString(pElement.getKey(), pElement.getValue());
					}
				}
				
				// Commit it.
				pEditor.commit();
			}
		}
	}
	
	private void setValue(String aKey, String strVal) {
		if( null == mValMap )
			return ;
		
		mValMap.setValue(aKey, strVal);
	}
	
	private String getString(String aKey) {
		ValueMap.Element pElement = (null != mValMap ? mValMap.getElement(aKey) : null);
		
		return null != pElement ? pElement.getValue() : "";
	}
	
	/**
	* method Name:setValue    
	* method Description:  
	* @param aKey
	* @param bValue   
	* void  
	* @exception   
	* @since  1.0.0
	 */
	private void setValue(String aKey, int nValue)
	{
		if ( null == mValMap )
			return ;
		
		mValMap.setValue(aKey, "" + nValue);
	}
	private void setValue(String aKey, float nValue)
	{
		if ( null == mValMap )
			return ;
		
		mValMap.setValue(aKey, "" + nValue);
	}

	
	/**
	* method Name:getValue    
	* method Description:  
	* @param aKey
	* @return   
	* boolean  
	* @exception   
	* @since  1.0.0
	 */
	private int getValue(String aKey)
	{
		ValueMap.Element pElement = (null != mValMap ? mValMap.getElement(aKey) : null);
		if ( null == pElement )
			return 0;
		
		return Integer.valueOf(pElement.getValue());
	}
	private float getFloat(String aKey)
	{
		ValueMap.Element pElement = (null != mValMap ? mValMap.getElement(aKey) : null);
		if ( null == pElement )
			return 0.0f;
		
		return Float.valueOf(pElement.getValue());
	}

	/**
	* Create a new Instance Preference.  
	*
	 */
	private Preference()
	{
		initialize();
	}
	
	/**
	* method Name:initialize    
	* method Description:     
	* void  
	* @exception   
	* @since  1.0.0
	 */
	private void initialize()
	{
		mPreferences = null;
		mValMap = null;
	}
	
	/**
	* method Name:setContext    
	* method Description:  
	* @param aContext   
	* void  
	* @exception   
	* @since  1.0.0
	 */
	private void setContext(Context aContext)
	{
		if ( null != aContext )
		{	
			// Load the preference.
			mPreferences = null;
			mPreferences = aContext.getSharedPreferences(PREF_NAME, 0);
			loadPref();
		}
	}
	
	/**
	* method Name:loadPref    
	* method Description:     
	* void  
	* @exception   
	* @since  1.0.0
	 */
	private void loadPref()
	{
		if ( (null == mPreferences) || (null != mValMap) )
			return ;
		
		mValMap = new ValueMap();
		final int nCount = PROPERTIES.length;
		for ( int nIdx = 0; nIdx < nCount; nIdx++ )
		{
			// Get the value from local storage.
			String strVal = mPreferences.getString(PROPERTIES[nIdx], DEFAULTS[nIdx]);
			
			// Save to memory.
			mValMap.addValue(PROPERTIES[nIdx], strVal);
		}
	}
	
	// Member instance.
	private static Preference mSelf = null;
	private SharedPreferences mPreferences;
	private ValueMap          mValMap;
	
	// Preference key.
	public  static final String PREF_NAME            = "ICSON_PREF";
	public  static final String PREF_IMAGE_MODE      = "IMAGE_MODE";
	public  static final String PREF_ANNOUNCE_ID     = "ANNOUNCE_ID";
	public  static final String PREF_PUSH_MESSAGE    = "PUSH_MESSAGE";
	public  static final String PREF_CONFIG_TIMETAG  = "CONFIG_TIMETAG";
	public  static final String PREF_PUSH_INTERVAL   = "PUSH_INTERVAL";
	public  static final String PREF_QQ_ACCOUNT  	 = "QQ_ACCOUNT";
	public  static final String PREF_YIXUN_ACCOUNT   = "YIXUN_ACCOUNT";
	public  static final String PREF_LAST_UID  		 = "LAST_UID";
	public  static final String PREF_BARCODE_ACESS   = "BARCODE_ACESS";
	public  static final String PREF_CONTACT_ACESS   = "CONTACT_ACESS";
	public  static final String PREF_HONOR3_ACESS    = "HONOR3_ACESS";
	public  static final String PREF_MAP_ACESS    	 = "MAP_ACESS";
	public  static final String PREF_CALL_ACESS    	 = "CALL_ACESS";


	
	//Portal info
	public  static final String PREF_PORTAL_INFO  = "PORTAL_INFO";
	public  static final String PREF_MAP_LASTCENTER  = "MAP_LASTCENTER";

	//Slotmachine
	public  static final String PREF_SLOT_CHANCE_EXP  = "SLOT_CHANCE_EXP";
	public  static final String PREF_SLOT_VERSION  = "SLOT_VERSION";
	public  static final String PREF_SHAKE_RANGE = "SHAKE_RANGE";
	
	//Project_version code
	public  static final String PREF_PROJ_VERSION  = "PROJ_VERSION";
	
	//first_sight
	public  static final String PREF_FIRST_SIGHT  = "FIRST_SIGHT";
	public  static final String DEFAULT_FIRST_SIGHT  = "0:0:0:0";
	public  static final int    FIRST_SIGHT_SLOT = 0;
	public  static final int    FIRST_SIGHT_QIANG = 1;
	public  static final int    FIRST_SIGHT_FILTER = 2;
	public  static final int    FIRST_SIGHT_HOTLIST = 3;
	
	//user_guide
	public  static final String PREF_USER_GUIDE  = "USER_GUIDE";
	public  static final String DEFAULT_USER_GUIDE  = "1:1:1:1";
	public  static final int    USER_GUIDE_FIRST_OPEN = 0;
	public  static final int    USER_GUIDE_SECOND_OPEN = 1;
	public  static final int    USER_GUIDE_USER_CENTER = 2;
	public  static final int    USER_GUIDE_SLOT = 3;
	
	// openCount
	public  static final String PREF_OPEN_COUNT = "OPEN_COUNT";
	
	private static final String[] PROPERTIES = {
												PREF_IMAGE_MODE	, 
												PREF_ANNOUNCE_ID,
												PREF_PUSH_MESSAGE,
												PREF_CONFIG_TIMETAG,
												PREF_PORTAL_INFO,
												PREF_MAP_LASTCENTER,
												PREF_PUSH_INTERVAL,
												PREF_SLOT_CHANCE_EXP,
												PREF_SLOT_VERSION,
												PREF_PROJ_VERSION,
												PREF_FIRST_SIGHT,
												PREF_SHAKE_RANGE,
												PREF_QQ_ACCOUNT,
												PREF_YIXUN_ACCOUNT,
												PREF_USER_GUIDE,
												PREF_OPEN_COUNT,
												PREF_LAST_UID,
												PREF_BARCODE_ACESS,
												PREF_CONTACT_ACESS,
												PREF_HONOR3_ACESS,
												PREF_MAP_ACESS,
												PREF_CALL_ACESS
												};
	// Default values for the preference.
	private static final int      MUTABLE_SIZE = 0;

	private static final String[] DEFAULTS = {"1","0", "1","","","", "10","3:0:0","","0",
				DEFAULT_FIRST_SIGHT,"0","","",DEFAULT_USER_GUIDE, "0","","0","0","0","0","0"};
}
