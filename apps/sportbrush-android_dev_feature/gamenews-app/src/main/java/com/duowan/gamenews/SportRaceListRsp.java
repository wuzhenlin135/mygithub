// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.5.5
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class SportRaceListRsp extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.SportRaceListRsp";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.SportRaceListRsp";
    }

    public java.util.Map<String, java.util.ArrayList<com.duowan.gamenews.RaceInfo>> allRaceList = null;

    public java.util.ArrayList<com.duowan.gamenews.sportInfo> sportList = null;

    public String attachInfo = "";

    public java.util.Map<String, java.util.ArrayList<com.duowan.gamenews.RaceInfo>> getAllRaceList()
    {
        return allRaceList;
    }

    public void  setAllRaceList(java.util.Map<String, java.util.ArrayList<com.duowan.gamenews.RaceInfo>> allRaceList)
    {
        this.allRaceList = allRaceList;
    }

    public java.util.ArrayList<com.duowan.gamenews.sportInfo> getSportList()
    {
        return sportList;
    }

    public void  setSportList(java.util.ArrayList<com.duowan.gamenews.sportInfo> sportList)
    {
        this.sportList = sportList;
    }

    public String getAttachInfo()
    {
        return attachInfo;
    }

    public void  setAttachInfo(String attachInfo)
    {
        this.attachInfo = attachInfo;
    }

    public SportRaceListRsp()
    {
        setAllRaceList(allRaceList);
        setSportList(sportList);
        setAttachInfo(attachInfo);
    }

    public SportRaceListRsp(java.util.Map<String, java.util.ArrayList<com.duowan.gamenews.RaceInfo>> allRaceList, java.util.ArrayList<com.duowan.gamenews.sportInfo> sportList, String attachInfo)
    {
        setAllRaceList(allRaceList);
        setSportList(sportList);
        setAttachInfo(attachInfo);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        SportRaceListRsp t = (SportRaceListRsp) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(allRaceList, t.allRaceList) && 
            com.duowan.taf.jce.JceUtil.equals(sportList, t.sportList) && 
            com.duowan.taf.jce.JceUtil.equals(attachInfo, t.attachInfo) );
    }

    public int hashCode()
    {
        try
        {
            throw new Exception("Need define key first!");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }
    public java.lang.Object clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void writeTo(com.duowan.taf.jce.JceOutputStream _os)
    {
        if (null != allRaceList)
        {
            _os.write(allRaceList, 0);
        }
        if (null != sportList)
        {
            _os.write(sportList, 1);
        }
        if (null != attachInfo)
        {
            _os.write(attachInfo, 2);
        }
    }

    static java.util.Map<String, java.util.ArrayList<com.duowan.gamenews.RaceInfo>> cache_allRaceList;
    static java.util.ArrayList<com.duowan.gamenews.sportInfo> cache_sportList;

    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        if(null == cache_allRaceList)
        {
            cache_allRaceList = new java.util.HashMap<String, java.util.ArrayList<com.duowan.gamenews.RaceInfo>>();
            String __var_62 = "";
            java.util.ArrayList<com.duowan.gamenews.RaceInfo> __var_63 = new java.util.ArrayList<com.duowan.gamenews.RaceInfo>();
            com.duowan.gamenews.RaceInfo __var_64 = new com.duowan.gamenews.RaceInfo();
            ((java.util.ArrayList<com.duowan.gamenews.RaceInfo>)__var_63).add(__var_64);
            cache_allRaceList.put(__var_62, __var_63);
        }
        setAllRaceList((java.util.Map<String, java.util.ArrayList<com.duowan.gamenews.RaceInfo>>) _is.read(cache_allRaceList, 0, false));

        if(null == cache_sportList)
        {
            cache_sportList = new java.util.ArrayList<com.duowan.gamenews.sportInfo>();
            com.duowan.gamenews.sportInfo __var_65 = new com.duowan.gamenews.sportInfo();
            ((java.util.ArrayList<com.duowan.gamenews.sportInfo>)cache_sportList).add(__var_65);
        }
        setSportList((java.util.ArrayList<com.duowan.gamenews.sportInfo>) _is.read(cache_sportList, 1, false));

        setAttachInfo( _is.readString(2, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(allRaceList, "allRaceList");
        _ds.display(sportList, "sportList");
        _ds.display(attachInfo, "attachInfo");
    }

}

