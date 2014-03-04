package com.retor.ViewPager_UI_tests;

/**
 * Created by retor on 19.01.14.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Account {
    public String access_token;
    public long user_id;

    public void save(Context context){
        SharedPreferences prefs = context.getSharedPreferences("token", Context.MODE_PRIVATE);//PreferenceManager.getDefaultSharedPreferences(context);
        Editor editor=prefs.edit();
        editor.putString("access_token", access_token);
        editor.putLong("user_id", user_id);
        editor.commit();
    }

    public void restore(Context context){
        SharedPreferences prefs = context.getSharedPreferences("token", Context.MODE_PRIVATE);//PreferenceManager.getDefaultSharedPreferences(context);
        access_token=prefs.getString("access_token", null);
        user_id=prefs.getLong("user_id", 0);
    }
}
