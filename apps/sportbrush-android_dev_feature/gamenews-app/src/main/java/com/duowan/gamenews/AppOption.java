// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class AppOption
{
    private static AppOption[] __values = new AppOption[1];
    private int __value;
    private String __T = new String();

    public static final int _FLAG_APP_OPTION_NOT_DISPLAY_TQ = 1;
    public static final AppOption FLAG_APP_OPTION_NOT_DISPLAY_TQ = new AppOption(0,_FLAG_APP_OPTION_NOT_DISPLAY_TQ,"FLAG_APP_OPTION_NOT_DISPLAY_TQ");

    public static AppOption convert(int val)
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

    public static AppOption convert(String val)
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

    private AppOption(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}
