package com.azazellj.a500pxreader.adapter.holder;

import android.content.Context;

import com.azazellj.a500pxreader.model.entity.Photo;
import com.azazellj.a500pxreader.view.PhotoCardView;

/**
 * Created by azazellj on 20.03.16.
 */
public class PhotoItemHolder extends BaseListItemViewHolder<Photo, PhotoCardView> {
    private PhotoCardView mView;

    public PhotoItemHolder(Context context) {
        this(new PhotoCardView(context));
    }

    public PhotoItemHolder(PhotoCardView photoCardView) {
        super(photoCardView);
        this.mView = photoCardView;
    }

    public PhotoCardView getView() {
        return this.mView;
    }

    public void updateView(Photo photo) {
        this.mView.updateView(photo);
    }
}