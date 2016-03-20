package com.azazellj.a500pxreader.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by azazellj on 20.03.16.
 */
public class ReaderApp extends Application {
    private static Context appContext;


    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();
    }


    public static Context getAppContext() {
        return appContext;
    }
}
