// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class GetSpecialArticleListRsp extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.GetSpecialArticleListRsp";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.GetSpecialArticleListRsp";
    }

    public java.util.ArrayList<com.duowan.gamenews.ArticleInfo> articleList = null;

    public java.util.Map<Integer, String> attachInfo = null;

    public boolean hasMore = true;

    public java.util.ArrayList<com.duowan.gamenews.PicInfo> cover = null;

    public String name = "";

    public String desc = "";

    public java.util.ArrayList<com.duowan.gamenews.ArticleInfo> getArticleList()
    {
        return articleList;
    }

    public void  setArticleList(java.util.ArrayList<com.duowan.gamenews.ArticleInfo> articleList)
    {
        this.articleList = articleList;
    }

    public java.util.Map<Integer, String> getAttachInfo()
    {
        return attachInfo;
    }

    public void  setAttachInfo(java.util.Map<Integer, String> attachInfo)
    {
        this.attachInfo = attachInfo;
    }

    public boolean getHasMore()
    {
        return hasMore;
    }

    public void  setHasMore(boolean hasMore)
    {
        this.hasMore = hasMore;
    }

    public java.util.ArrayList<com.duowan.gamenews.PicInfo> getCover()
    {
        return cover;
    }

    public void  setCover(java.util.ArrayList<com.duowan.gamenews.PicInfo> cover)
    {
        this.cover = cover;
    }

    public String getName()
    {
        return name;
    }

    public void  setName(String name)
    {
        this.name = name;
    }

    public String getDesc()
    {
        return desc;
    }

    public void  setDesc(String desc)
    {
        this.desc = desc;
    }

    public GetSpecialArticleListRsp()
    {
        setArticleList(articleList);
        setAttachInfo(attachInfo);
        setHasMore(hasMore);
        setCover(cover);
        setName(name);
        setDesc(desc);
    }

    public GetSpecialArticleListRsp(java.util.ArrayList<com.duowan.gamenews.ArticleInfo> articleList, java.util.Map<Integer, String> attachInfo, boolean hasMore, java.util.ArrayList<com.duowan.gamenews.PicInfo> cover, String name, String desc)
    {
        setArticleList(articleList);
        setAttachInfo(attachInfo);
        setHasMore(hasMore);
        setCover(cover);
        setName(name);
        setDesc(desc);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetSpecialArticleListRsp t = (GetSpecialArticleListRsp) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(articleList, t.articleList) && 
            com.duowan.taf.jce.JceUtil.equals(attachInfo, t.attachInfo) && 
            com.duowan.taf.jce.JceUtil.equals(hasMore, t.hasMore) && 
            com.duowan.taf.jce.JceUtil.equals(cover, t.cover) && 
            com.duowan.taf.jce.JceUtil.equals(name, t.name) && 
            com.duowan.taf.jce.JceUtil.equals(desc, t.desc) );
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
        if (null != articleList)
        {
            _os.write(articleList, 0);
        }
        if (null != attachInfo)
        {
            _os.write(attachInfo, 1);
        }
        _os.write(hasMore, 2);
        if (null != cover)
        {
            _os.write(cover, 3);
        }
        if (null != name)
        {
            _os.write(name, 4);
        }
        if (null != desc)
        {
            _os.write(desc, 5);
        }
    }

    static java.util.ArrayList<com.duowan.gamenews.ArticleInfo> cache_articleList;
    static java.util.Map<Integer, String> cache_attachInfo;
    static java.util.ArrayList<com.duowan.gamenews.PicInfo> cache_cover;

    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        if(null == cache_articleList)
        {
            cache_articleList = new java.util.ArrayList<com.duowan.gamenews.ArticleInfo>();
            com.duowan.gamenews.ArticleInfo __var_39 = new com.duowan.gamenews.ArticleInfo();
            ((java.util.ArrayList<com.duowan.gamenews.ArticleInfo>)cache_articleList).add(__var_39);
        }
        setArticleList((java.util.ArrayList<com.duowan.gamenews.ArticleInfo>) _is.read(cache_articleList, 0, false));

        if(null == cache_attachInfo)
        {
            cache_attachInfo = new java.util.HashMap<Integer, String>();
            Integer __var_40 = 0;
            String __var_41 = "";
            cache_attachInfo.put(__var_40, __var_41);
        }
        setAttachInfo((java.util.Map<Integer, String>) _is.read(cache_attachInfo, 1, false));

        setHasMore((boolean) _is.read(hasMore, 2, false));

        if(null == cache_cover)
        {
            cache_cover = new java.util.ArrayList<com.duowan.gamenews.PicInfo>();
            com.duowan.gamenews.PicInfo __var_42 = new com.duowan.gamenews.PicInfo();
            ((java.util.ArrayList<com.duowan.gamenews.PicInfo>)cache_cover).add(__var_42);
        }
        setCover((java.util.ArrayList<com.duowan.gamenews.PicInfo>) _is.read(cache_cover, 3, false));

        setName( _is.readString(4, false));

        setDesc( _is.readString(5, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(articleList, "articleList");
        _ds.display(attachInfo, "attachInfo");
        _ds.display(hasMore, "hasMore");
        _ds.display(cover, "cover");
        _ds.display(name, "name");
        _ds.display(desc, "desc");
    }

}

