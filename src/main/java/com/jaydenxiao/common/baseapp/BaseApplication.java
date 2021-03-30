package com.jaydenxiao.common.baseapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import cn.bmob.v3.Bmob;


/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;
    /**
     * APPID：在控制台的应用-设置-
     */
    public static String APPID = "4e11592e1283a60d259c43cfe63b9609";
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;

        Bmob.initialize(this, APPID);
    }

    public static Context getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
