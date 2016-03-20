package com.azazellj.a500pxreader.adapter;

import android.view.ViewGroup;

import com.azazellj.a500pxreader.adapter.holder.PhotoItemHolder;
import com.azazellj.a500pxreader.model.entity.Photo;
import com.azazellj.a500pxreader.view.PhotoCardView;

import java.util.List;

/**
 * Created by azazellj on 20.03.16.
 */
public class PhotosListAdapter extends BaseListAdapter<Photo, PhotoCardView, PhotoItemHolder> {

    @Override
    public PhotoItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotoItemHolder(parent.getContext());
    }

    @Override
    public void onBindViewHolder(PhotoItemHolder holder, int position) {
        holder.updateView(getItem(position));
    }

    public PhotosListAdapter(List<Photo> mDataSet) {
        setItems(mDataSet);
    }
}
