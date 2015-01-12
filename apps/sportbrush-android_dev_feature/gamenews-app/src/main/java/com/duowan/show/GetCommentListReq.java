// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.5.5
// Generated from `show.jce'
// **********************************************************************

package com.duowan.show;

public final class GetCommentListReq extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "show.GetCommentListReq";
    }

    public String fullClassName()
    {
        return "com.duowan.show.GetCommentListReq";
    }

    public int topicId = 0;

    public String attachInfo = "";

    public int getTopicId()
    {
        return topicId;
    }

    public void  setTopicId(int topicId)
    {
        this.topicId = topicId;
    }

    public String getAttachInfo()
    {
        return attachInfo;
    }

    public void  setAttachInfo(String attachInfo)
    {
        this.attachInfo = attachInfo;
    }

    public GetCommentListReq()
    {
        setTopicId(topicId);
        setAttachInfo(attachInfo);
    }

    public GetCommentListReq(int topicId, String attachInfo)
    {
        setTopicId(topicId);
        setAttachInfo(attachInfo);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetCommentListReq t = (GetCommentListReq) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(topicId, t.topicId) && 
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
        _os.write(topicId, 0);
        if (null != attachInfo)
        {
            _os.write(attachInfo, 1);
        }
    }


    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setTopicId((int) _is.read(topicId, 0, false));

        setAttachInfo( _is.readString(1, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(topicId, "topicId");
        _ds.display(attachInfo, "attachInfo");
    }

}

