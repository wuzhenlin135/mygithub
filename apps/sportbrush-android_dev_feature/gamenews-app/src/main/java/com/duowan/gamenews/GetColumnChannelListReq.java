// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.5.5
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class GetColumnChannelListReq extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.GetColumnChannelListReq";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.GetColumnChannelListReq";
    }

    public int id = 0;

    public String attachInfo = "";

    public int count = 0;

    public int getId()
    {
        return id;
    }

    public void  setId(int id)
    {
        this.id = id;
    }

    public String getAttachInfo()
    {
        return attachInfo;
    }

    public void  setAttachInfo(String attachInfo)
    {
        this.attachInfo = attachInfo;
    }

    public int getCount()
    {
        return count;
    }

    public void  setCount(int count)
    {
        this.count = count;
    }

    public GetColumnChannelListReq()
    {
        setId(id);
        setAttachInfo(attachInfo);
        setCount(count);
    }

    public GetColumnChannelListReq(int id, String attachInfo, int count)
    {
        setId(id);
        setAttachInfo(attachInfo);
        setCount(count);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetColumnChannelListReq t = (GetColumnChannelListReq) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(id, t.id) && 
            com.duowan.taf.jce.JceUtil.equals(attachInfo, t.attachInfo) && 
            com.duowan.taf.jce.JceUtil.equals(count, t.count) );
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
        _os.write(id, 0);
        if (null != attachInfo)
        {
            _os.write(attachInfo, 1);
        }
        _os.write(count, 2);
    }


    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setId((int) _is.read(id, 0, false));

        setAttachInfo( _is.readString(1, false));

        setCount((int) _is.read(count, 2, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(id, "id");
        _ds.display(attachInfo, "attachInfo");
        _ds.display(count, "count");
    }

}

