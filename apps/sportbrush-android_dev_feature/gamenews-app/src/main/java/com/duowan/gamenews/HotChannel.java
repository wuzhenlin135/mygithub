// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class HotChannel extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.HotChannel";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.HotChannel";
    }

    public com.duowan.gamenews.Channel Channel = null;

    public int Comments = 0;

    public String Icon = "";

    public com.duowan.gamenews.Channel getChannel()
    {
        return Channel;
    }

    public void  setChannel(com.duowan.gamenews.Channel Channel)
    {
        this.Channel = Channel;
    }

    public int getComments()
    {
        return Comments;
    }

    public void  setComments(int Comments)
    {
        this.Comments = Comments;
    }

    public String getIcon()
    {
        return Icon;
    }

    public void  setIcon(String Icon)
    {
        this.Icon = Icon;
    }

    public HotChannel()
    {
        setChannel(Channel);
        setComments(Comments);
        setIcon(Icon);
    }

    public HotChannel(com.duowan.gamenews.Channel Channel, int Comments, String Icon)
    {
        setChannel(Channel);
        setComments(Comments);
        setIcon(Icon);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        HotChannel t = (HotChannel) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(Channel, t.Channel) && 
            com.duowan.taf.jce.JceUtil.equals(Comments, t.Comments) && 
            com.duowan.taf.jce.JceUtil.equals(Icon, t.Icon) );
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
        if (null != Channel)
        {
            _os.write(Channel, 0);
        }
        _os.write(Comments, 1);
        if (null != Icon)
        {
            _os.write(Icon, 2);
        }
    }

    static com.duowan.gamenews.Channel cache_Channel;

    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        if(null == cache_Channel)
        {
            cache_Channel = new com.duowan.gamenews.Channel();
        }
        setChannel((com.duowan.gamenews.Channel) _is.read(cache_Channel, 0, false));

        setComments((int) _is.read(Comments, 1, false));

        setIcon( _is.readString(2, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(Channel, "Channel");
        _ds.display(Comments, "Comments");
        _ds.display(Icon, "Icon");
    }

}

