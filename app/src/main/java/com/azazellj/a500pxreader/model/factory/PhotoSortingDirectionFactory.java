package com.azazellj.a500pxreader.model.factory;

import com.azazellj.a500pxreader.model.PhotoSortingDirectionValue;

import java.util.HashMap;

/**
 * Created by azazellj on 19.03.16.
 */
public class PhotoSortingDirectionFactory extends Factory<String, PhotoSortingDirectionValue> {
    @Override
    public HashMap<String, PhotoSortingDirectionValue> create() {
        HashMap<String, PhotoSortingDirectionValue> photoSortingDirectionOrders = new HashMap<>();

        photoSortingDirectionOrders.put("asc", new PhotoSortingDirectionValue("asc", "Sort in ascending order (lowest or least-recent first)"));
        photoSortingDirectionOrders.put("desc", new PhotoSortingDirectionValue("desc", "Sort in descending order (highest or most-recent first). This is the default."));

        return photoSortingDirectionOrders;
    }

    @Override
    public String getDefaultKey() {
        return "asc";
    }
}
