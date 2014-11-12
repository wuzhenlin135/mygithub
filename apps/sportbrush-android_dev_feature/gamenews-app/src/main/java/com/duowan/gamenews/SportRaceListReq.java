// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class SportRaceListReq extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.SportRaceListReq";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.SportRaceListReq";
    }

    public int time = 0;

    public String attachInfo = "";

    public int getTime()
    {
        return time;
    }

    public void  setTime(int time)
    {
        this.time = time;
    }

    public String getAttachInfo()
    {
        return attachInfo;
    }

    public void  setAttachInfo(String attachInfo)
    {
        this.attachInfo = attachInfo;
    }

    public SportRaceListReq()
    {
        setTime(time);
        setAttachInfo(attachInfo);
    }

    public SportRaceListReq(int time, String attachInfo)
    {
        setTime(time);
        setAttachInfo(attachInfo);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        SportRaceListReq t = (SportRaceListReq) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(time, t.time) && 
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
        _os.write(time, 0);
        if (null != attachInfo)
        {
            _os.write(attachInfo, 1);
        }
    }


    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setTime((int) _is.read(time, 0, false));

        setAttachInfo( _is.readString(1, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(time, "time");
        _ds.display(attachInfo, "attachInfo");
    }

}

