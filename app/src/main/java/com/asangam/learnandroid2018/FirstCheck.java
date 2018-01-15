package com.asangam.learnandroid2018;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by asangam on 12/30/17.
 */

public class FirstCheck {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public FirstCheck(Context context)
    {
        this.context=context;
        pref=context.getSharedPreferences("first",0);
        editor=pref.edit();

    }

    public void setFirst(boolean isFirst)
    {
        editor.putBoolean("check",isFirst);
        editor.commit();
    }

    public boolean Check()
    {
        return pref.getBoolean("check",true);
    }

}
