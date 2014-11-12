// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `autonews.jce'
// **********************************************************************

package com.duowan.autonews;

public final class GetCarListRsp extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "autonews.GetCarListRsp";
    }

    public String fullClassName()
    {
        return "com.duowan.autonews.GetCarListRsp";
    }

    public int hasMore = 0;

    public String attachInfo = "";

    public java.util.ArrayList<com.duowan.autonews.CarCategory> carList = null;

    public String image = "";

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

    public java.util.ArrayList<com.duowan.autonews.CarCategory> getCarList()
    {
        return carList;
    }

    public void  setCarList(java.util.ArrayList<com.duowan.autonews.CarCategory> carList)
    {
        this.carList = carList;
    }

    public String getImage()
    {
        return image;
    }

    public void  setImage(String image)
    {
        this.image = image;
    }

    public GetCarListRsp()
    {
        setHasMore(hasMore);
        setAttachInfo(attachInfo);
        setCarList(carList);
        setImage(image);
    }

    public GetCarListRsp(int hasMore, String attachInfo, java.util.ArrayList<com.duowan.autonews.CarCategory> carList, String image)
    {
        setHasMore(hasMore);
        setAttachInfo(attachInfo);
        setCarList(carList);
        setImage(image);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetCarListRsp t = (GetCarListRsp) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(hasMore, t.hasMore) && 
            com.duowan.taf.jce.JceUtil.equals(attachInfo, t.attachInfo) && 
            com.duowan.taf.jce.JceUtil.equals(carList, t.carList) && 
            com.duowan.taf.jce.JceUtil.equals(image, t.image) );
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
        _os.write(hasMore, 0);
        if (null != attachInfo)
        {
            _os.write(attachInfo, 1);
        }
        if (null != carList)
        {
            _os.write(carList, 2);
        }
        if (null != image)
        {
            _os.write(image, 3);
        }
    }

    static java.util.ArrayList<com.duowan.autonews.CarCategory> cache_carList;

    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setHasMore((int) _is.read(hasMore, 0, false));

        setAttachInfo( _is.readString(1, false));

        if(null == cache_carList)
        {
            cache_carList = new java.util.ArrayList<com.duowan.autonews.CarCategory>();
            com.duowan.autonews.CarCategory __var_6 = new com.duowan.autonews.CarCategory();
            ((java.util.ArrayList<com.duowan.autonews.CarCategory>)cache_carList).add(__var_6);
        }
        setCarList((java.util.ArrayList<com.duowan.autonews.CarCategory>) _is.read(cache_carList, 2, false));

        setImage( _is.readString(3, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(hasMore, "hasMore");
        _ds.display(attachInfo, "attachInfo");
        _ds.display(carList, "carList");
        _ds.display(image, "image");
    }

}

