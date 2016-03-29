package com.azazellj.a500pxreader;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.azazellj.a500pxreader.adapter.PhotosListAdapter;
import com.azazellj.a500pxreader.data.Api;
import com.azazellj.a500pxreader.model.ResponseObject;
import com.azazellj.a500pxreader.model.entity.Photo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        new Api().getNewPhotos(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                PhotosListAdapter adapter = new PhotosListAdapter(response.body().photos);
                photosListView.setAdapter(adapter);

                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.download:
                makeCall();
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public void onRefresh() {
        makeCall();
    }
}