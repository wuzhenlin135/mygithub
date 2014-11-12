// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class GetRacePortalReq extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.GetRacePortalReq";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.GetRacePortalReq";
    }

    public int count = 0;

    public String attachInfo = "";

    public int getCount()
    {
        return count;
    }

    public void  setCount(int count)
    {
        this.count = count;
    }

    public String getAttachInfo()
    {
        return attachInfo;
    }

    public void  setAttachInfo(String attachInfo)
    {
        this.attachInfo = attachInfo;
    }

    public GetRacePortalReq()
    {
        setCount(count);
        setAttachInfo(attachInfo);
    }

    public GetRacePortalReq(int count, String attachInfo)
    {
        setCount(count);
        setAttachInfo(attachInfo);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetRacePortalReq t = (GetRacePortalReq) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(count, t.count) && 
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
        _os.write(count, 0);
        if (null != attachInfo)
        {
            _os.write(attachInfo, 1);
        }
    }


    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setCount((int) _is.read(count, 0, false));

        setAttachInfo( _is.readString(1, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(count, "count");
        _ds.display(attachInfo, "attachInfo");
    }

}

