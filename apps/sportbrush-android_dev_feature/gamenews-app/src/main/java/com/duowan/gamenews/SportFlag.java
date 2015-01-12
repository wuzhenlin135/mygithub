// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.5.5
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class SportFlag
{
    private static SportFlag[] __values = new SportFlag[2];
    private int __value;
    private String __T = new String();

    public static final int _SPORT_INDEX_FLAG = 1;
    public static final SportFlag SPORT_INDEX_FLAG = new SportFlag(0,_SPORT_INDEX_FLAG,"SPORT_INDEX_FLAG");
    public static final int _SPORT_NOINDEX_FLAG = 2;
    public static final SportFlag SPORT_NOINDEX_FLAG = new SportFlag(1,_SPORT_NOINDEX_FLAG,"SPORT_NOINDEX_FLAG");

    public static SportFlag convert(int val)
    {
        for(int __i = 0; __i < __values.length; ++__i)
        {
            if(__values[__i].value() == val)
            {
                return __values[__i];
            }
        }
        assert false;
        return null;
    }

    public static SportFlag convert(String val)
    {
        for(int __i = 0; __i < __values.length; ++__i)
        {
            if(__values[__i].toString().equals(val))
            {
                return __values[__i];
            }
        }
        assert false;
        return null;
    }

    public int value()
    {
        return __value;
    }

    public String toString()
    {
        return __T;
    }

    private SportFlag(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}
