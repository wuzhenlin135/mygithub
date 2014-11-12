// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class switchsInfo extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.switchsInfo";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.switchsInfo";
    }

    public int flag = 0;

    public String name = "";

    public String url = "";

    public int getFlag()
    {
        return flag;
    }

    public void  setFlag(int flag)
    {
        this.flag = flag;
    }

    public String getName()
    {
        return name;
    }

    public void  setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void  setUrl(String url)
    {
        this.url = url;
    }

    public switchsInfo()
    {
        setFlag(flag);
        setName(name);
        setUrl(url);
    }

    public switchsInfo(int flag, String name, String url)
    {
        setFlag(flag);
        setName(name);
        setUrl(url);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        switchsInfo t = (switchsInfo) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(flag, t.flag) && 
            com.duowan.taf.jce.JceUtil.equals(name, t.name) && 
            com.duowan.taf.jce.JceUtil.equals(url, t.url) );
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
        _os.write(flag, 0);
        if (null != name)
        {
            _os.write(name, 1);
        }
        if (null != url)
        {
            _os.write(url, 2);
        }
    }


    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setFlag((int) _is.read(flag, 0, false));

        setName( _is.readString(1, false));

        setUrl( _is.readString(2, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(flag, "flag");
        _ds.display(name, "name");
        _ds.display(url, "url");
    }

}

