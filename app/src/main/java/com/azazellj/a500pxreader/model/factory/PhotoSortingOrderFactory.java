package com.azazellj.a500pxreader.model.factory;

import com.azazellj.a500pxreader.model.PhotoSortingOrderValue;

import java.util.HashMap;

/**
 * Created by azazellj on 19.03.16.
 */
public class PhotoSortingOrderFactory extends Factory<String, PhotoSortingOrderValue> {
    @Override
    public HashMap<String, PhotoSortingOrderValue> create() {
        HashMap<String, PhotoSortingOrderValue> photoSortingOrders = new HashMap<>();

        photoSortingOrders.put("created_at", new PhotoSortingOrderValue("created_at", "Sort by time of upload"));
        photoSortingOrders.put("rating", new PhotoSortingOrderValue("rating", "Sort by rating"));
        photoSortingOrders.put("highest_rating", new PhotoSortingOrderValue("highest_rating", "Sort by the highest rating the photo reached"));
        photoSortingOrders.put("times_viewed", new PhotoSortingOrderValue("times_viewed", "Sort by view count"));
        photoSortingOrders.put("votes_count", new PhotoSortingOrderValue("votes_count", "Sort by votes count"));
        photoSortingOrders.put("comments_count", new PhotoSortingOrderValue("comments_count", "Sort by comments count"));
        photoSortingOrders.put("taken_at", new PhotoSortingOrderValue("taken_at", "Sort by the original date of the image extracted from metadata (might not be available for all images)"));

        return photoSortingOrders;
    }

    @Override
    public String getDefaultKey() {
        return "created_at";
    }
}
