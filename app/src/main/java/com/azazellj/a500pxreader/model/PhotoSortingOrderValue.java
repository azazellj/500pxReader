package com.azazellj.a500pxreader.model;

/**
 * Created by azazellj on 19.03.16.
 */
public class PhotoSortingOrderValue {
    public String key;
    public String description;

    public PhotoSortingOrderValue(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
