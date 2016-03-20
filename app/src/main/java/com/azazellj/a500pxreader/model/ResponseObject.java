package com.azazellj.a500pxreader.model;

import com.azazellj.a500pxreader.model.entity.Photo;

import java.util.List;

/**
 * Created by azazellj on 19.03.16.
 */
public class ResponseObject {

    public String feature;
    public Object filters;
    public int current_page;
    public int total_pages;
    public int total_items;
    public List<Photo> photos;


}
