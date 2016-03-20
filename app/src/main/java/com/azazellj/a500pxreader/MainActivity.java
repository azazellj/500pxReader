package com.azazellj.a500pxreader;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.azazellj.a500pxreader.adapter.PhotosListAdapter;
import com.azazellj.a500pxreader.data.PhotoResourceService;
import com.azazellj.a500pxreader.model.ParamsLoader;
import com.azazellj.a500pxreader.model.ResponseObject;
import com.azazellj.a500pxreader.model.entity.Photo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    protected SwipeRefreshLayout refreshLayout;
    protected RecyclerView photosListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshLayout = ButterKnife.findById(this, R.id.refreshPhotoLayout);
        photosListView = ButterKnife.findById(this, R.id.photoListView);

        refreshLayout.setOnRefreshListener(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        photosListView.setLayoutManager(layoutManager);

        List<Photo> photoList = new ArrayList<>(0);
        PhotosListAdapter adapter = new PhotosListAdapter(photoList);
        photosListView.setAdapter(adapter);
    }

    public void makeCall() {
        refreshLayout.setRefreshing(true);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.500px.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        PhotoResourceService service = retrofit.create(PhotoResourceService.class);

        Map<String, Object> params = new ParamsLoader().build();

        service.getPhotos(params).enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                PhotosListAdapter adapter = new PhotosListAdapter(response.body().photos);
                photosListView.setAdapter(adapter);

                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                String sss = "";
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onRefresh() {
        makeCall();
    }
}