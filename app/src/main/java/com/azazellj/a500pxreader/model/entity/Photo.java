package com.azazellj.a500pxreader.model.entity;

import java.util.List;

/**
 * Created by azazellj on 18.03.16.
 */
public class Photo extends Entity {
    public String name;
    public String description;
    public String camera;
    public String lens;
    public String focal_length;
    public String iso;
    public String shutter_speed;
    public String aperture;
    public int times_viewed;
    public float rating;
    public int status;
    public String created_at;
    public short category;
    public String location;
    public boolean privacy;
    public float latitude;
    public float longitude;
    public String taken_at;
    public boolean for_sale;
    public int width;
    public int height;
    public int votes_count;
    public int comments_count;
    public boolean nsfw;
    public int sales_count;
    public float highest_rating;
    public Object highest_rating_date;
    public Object converted;
    public String image_url;
    public List<PhotoUrl> images;
    public User user;
    public int galleries_count;
}
