package com.example.ess;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

public class multidex extends MultiDexApplication {
    //you can leave this empty or override methods if you like so the thing is that you need to extend from MultiDexApplication
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }}