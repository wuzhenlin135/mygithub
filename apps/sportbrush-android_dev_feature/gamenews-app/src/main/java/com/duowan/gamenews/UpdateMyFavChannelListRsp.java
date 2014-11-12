// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class UpdateMyFavChannelListRsp extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.UpdateMyFavChannelListRsp";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.UpdateMyFavChannelListRsp";
    }

    public java.util.ArrayList<com.duowan.gamenews.Channel> channelList = null;

    public int hasMore = 0;

    public String attachInfo = "";

    public java.util.ArrayList<com.duowan.gamenews.Channel> getChannelList()
    {
        return channelList;
    }

    public void  setChannelList(java.util.ArrayList<com.duowan.gamenews.Channel> channelList)
    {
        this.channelList = channelList;
    }

    public int getHasMore()
    {
        return hasMore;
    }

    public void  setHasMore(int hasMore)
    {
        this.hasMore = hasMore;
    }

    public String getAttachInfo()
    {
        return attachInfo;
    }

    public void  setAttachInfo(String attachInfo)
    {
        this.attachInfo = attachInfo;
    }

    public UpdateMyFavChannelListRsp()
    {
        setChannelList(channelList);
        setHasMore(hasMore);
        setAttachInfo(attachInfo);
    }

    public UpdateMyFavChannelListRsp(java.util.ArrayList<com.duowan.gamenews.Channel> channelList, int hasMore, String attachInfo)
    {
        setChannelList(channelList);
        setHasMore(hasMore);
        setAttachInfo(attachInfo);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        UpdateMyFavChannelListRsp t = (UpdateMyFavChannelListRsp) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(channelList, t.channelList) && 
            com.duowan.taf.jce.JceUtil.equals(hasMore, t.hasMore) && 
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
        if (null != channelList)
        {
            _os.write(channelList, 0);
        }
        _os.write(hasMore, 1);
        if (null != attachInfo)
        {
            _os.write(attachInfo, 2);
        }
    }

    static java.util.ArrayList<com.duowan.gamenews.Channel> cache_channelList;

    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        if(null == cache_channelList)
        {
            cache_channelList = new java.util.ArrayList<com.duowan.gamenews.Channel>();
            com.duowan.gamenews.Channel __var_28 = new com.duowan.gamenews.Channel();
            ((java.util.ArrayList<com.duowan.gamenews.Channel>)cache_channelList).add(__var_28);
        }
        setChannelList((java.util.ArrayList<com.duowan.gamenews.Channel>) _is.read(cache_channelList, 0, false));

        setHasMore((int) _is.read(hasMore, 1, false));

        setAttachInfo( _is.readString(2, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(channelList, "channelList");
        _ds.display(hasMore, "hasMore");
        _ds.display(attachInfo, "attachInfo");
    }

}

