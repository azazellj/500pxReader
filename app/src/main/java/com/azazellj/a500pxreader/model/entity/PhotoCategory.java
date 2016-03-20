package com.azazellj.a500pxreader.model.entity;

import com.azazellj.a500pxreader.model.entity.Entity;

/**
 * Created by azazellj on 19.03.16.
 */
public class PhotoCategory extends Entity {
    public String categoryName;

    public PhotoCategory(int id, String categoryName) {
        super(id);
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
