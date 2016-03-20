package com.azazellj.a500pxreader.data;

import com.azazellj.a500pxreader.model.ResponseObject;
import com.azazellj.a500pxreader.model.entity.Photo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by azazellj on 18.03.16.
 */
public interface PhotoResourceService {
    @GET("v1/photos")
    Call<ResponseObject> getPhotos(@QueryMap Map<String, Object> params);
}
