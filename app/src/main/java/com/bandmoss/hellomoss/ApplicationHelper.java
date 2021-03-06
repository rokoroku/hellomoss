package com.bandmoss.hellomoss;

import android.app.Application;

import com.bandmoss.hellomoss.util.WebkitCookieManagerProxy;

/**
 * Created by rok on 2015. 3. 17..
 */
public class ApplicationHelper extends Application {

    private static ApplicationHelper instance;

    public static ApplicationHelper getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        android.webkit.CookieSyncManager.createInstance(this);
        android.webkit.CookieManager.getInstance().setAcceptCookie(true);
        WebkitCookieManagerProxy coreCookieManager = new WebkitCookieManagerProxy(null, java.net.CookiePolicy.ACCEPT_ALL);
        java.net.CookieHandler.setDefault(coreCookieManager);
    }
}
