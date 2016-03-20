package com.azazellj.a500pxreader.model.factory;

import com.azazellj.a500pxreader.model.entity.PhotoCategory;

import java.util.HashMap;

/**
 * Created by azazellj on 19.03.16.
 */
public class CategoryFactory extends Factory<Integer, PhotoCategory> {
    @Override
    public HashMap<Integer, PhotoCategory> create() {
        HashMap<Integer, PhotoCategory> photoCategories = new HashMap<>();

        photoCategories.put(0, new PhotoCategory(0, "Uncategorized"));
        photoCategories.put(10, new PhotoCategory(10, "Abstract"));
        photoCategories.put(11, new PhotoCategory(11, "Animals"));
        photoCategories.put(5, new PhotoCategory(5, "Black and White"));
        photoCategories.put(1, new PhotoCategory(1, "Celebrities"));
        photoCategories.put(9, new PhotoCategory(9, "City and Architecture"));
        photoCategories.put(15, new PhotoCategory(15, "Commercial"));
        photoCategories.put(16, new PhotoCategory(16, "Concert"));
        photoCategories.put(20, new PhotoCategory(20, "Family"));
        photoCategories.put(14, new PhotoCategory(14, "Fashion"));
        photoCategories.put(2, new PhotoCategory(2, "Film"));
        photoCategories.put(24, new PhotoCategory(24, "Fine Art"));
        photoCategories.put(23, new PhotoCategory(23, "Food"));
        photoCategories.put(3, new PhotoCategory(3, "Journalism"));
        photoCategories.put(8, new PhotoCategory(8, "Landscapes"));
        photoCategories.put(12, new PhotoCategory(12, "Macro"));
        photoCategories.put(18, new PhotoCategory(18, "Nature"));
        photoCategories.put(4, new PhotoCategory(4, "Nude"));
        photoCategories.put(7, new PhotoCategory(7, "People"));
        photoCategories.put(19, new PhotoCategory(19, "Performing Arts"));
        photoCategories.put(17, new PhotoCategory(17, "Sport"));
        photoCategories.put(6, new PhotoCategory(6, "Still Life"));
        photoCategories.put(21, new PhotoCategory(21, "Street"));
        photoCategories.put(26, new PhotoCategory(26, "Transportation New!"));
        photoCategories.put(13, new PhotoCategory(13, "Travel"));
        photoCategories.put(22, new PhotoCategory(22, "Underwater"));
        photoCategories.put(27, new PhotoCategory(27, "Urban Exploration New!"));
        photoCategories.put(25, new PhotoCategory(25, "Wedding New!"));

        return photoCategories;
    }

    @Override
    public Integer getDefaultKey() {
        return 0;
    }
}
