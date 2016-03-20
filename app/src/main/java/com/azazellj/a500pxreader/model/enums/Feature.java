package com.azazellj.a500pxreader.model.enums;

/**
 * Created by azazellj on 19.03.16.
 */
public enum Feature {
    POPULAR("popular"),
    HIGHEST_RATED("highest_rated"),
    UPCOMING("upcoming"),
    EDITORS("editors"),
    FRESH_TODAY("fresh_today"),
    FRESH_YESTERDAY("fresh_yesterday"),
    FRESH_WEEK("fresh_week");


    private String name;

    Feature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
