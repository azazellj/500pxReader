package com.azazellj.a500pxreader.data;

import com.azazellj.a500pxreader.model.ParamsLoader;
import com.azazellj.a500pxreader.model.ResponseObject;

import java.io.IOException;
import java.util.Map;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by azazellj on 29.03.16.
 */
public class Api {
    private Map<String, Object> params;
    private Retrofit retrofit;
    private PhotoResourceService service;

    public Api() {
        retrofit = new Retrofit.Builder().baseUrl("https://api.500px.com/").addConverterFactory(GsonConverterFactory.create()).build();
        params = new ParamsLoader().build();
        service = retrofit.create(PhotoResourceService.class);
    }

    public void getNewPhotos(Callback<ResponseObject> callback) {
        params = new ParamsLoader().build();
        service.getPhotos(params).enqueue(callback);
    }

    public void getRandomPhoto(Callback<ResponseObject> callback) {
        params = new ParamsLoader().setResultsPerPage(1).build();
        service.getPhotos(params).enqueue(callback);
    }

    public Response<ResponseObject> getRandomPhoto() throws IOException {
        params = new ParamsLoader().setResultsPerPage(1).build();
        return service.getPhotos(params).execute();
    }
}
