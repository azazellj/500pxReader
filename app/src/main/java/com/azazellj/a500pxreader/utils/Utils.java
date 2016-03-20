package com.azazellj.a500pxreader.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import com.azazellj.a500pxreader.app.ReaderApp;

/**
 * Created by azazellj on 20.03.16.
 */
public class Utils {
    public static int convertDpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ReaderApp.getAppContext().getResources().getDisplayMetrics());
    }

    public static int getScreenWidth() {
        WindowManager windowManager = (WindowManager) ReaderApp.getAppContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        return displayMetrics.widthPixels;
    }
}
