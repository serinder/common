package com.jaydenxiao.common.baseapp;

import android.content.Context;

/**
 * App内存缓存
 */
public class AppCache {
    private Context context;//应用实例
    private volatile static AppCache instance;
    private String token="";
    private String userId="10000";
    private String userName="锋";
    private String icon="Image/20160819/1471570856669.jpeg";
    private String token_type="";
    private long expires_at=0;
/**
 * Copyright 2021 bejson.com
 */






    private AppCache() {
    }
    public static AppCache getInstance() {
        if (null == instance) {
            synchronized (AppCache.class) {
                if (instance == null) {
                    instance = new AppCache();
                }
            }
        }
        return instance;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
    public String getToken_type() {
        return token_type;
    }

    public void setExpires_at(long expires_at) {
        this.expires_at = expires_at;
    }
    public long getExpires_at() {
        return expires_at;
    }
}
