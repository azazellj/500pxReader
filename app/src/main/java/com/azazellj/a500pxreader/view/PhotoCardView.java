package com.azazellj.a500pxreader.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.azazellj.a500pxreader.R;
import com.azazellj.a500pxreader.utils.Utils;
import com.azazellj.a500pxreader.model.entity.Photo;
import com.azazellj.a500pxreader.model.entity.PhotoSize;
import com.azazellj.a500pxreader.model.entity.PhotoUrl;
import com.azazellj.a500pxreader.model.factory.PhotoSizeFactory;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import butterknife.ButterKnife;

/**
 * Created by azazellj on 20.03.16.
 */
public class PhotoCardView extends CardView {
    private ImageView imageView;

    public PhotoCardView(Context context) {
        this(context, null);
    }

    public PhotoCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PhotoCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.adapter_item_photo, this);
        this.imageView = ButterKnife.findById(this, R.id.imageView);
    }

    public void updateView(final Photo photo) {

        Picasso.with(this.getContext()).load(photo.image_url).into(this.imageView);

        PhotoUrl photoUrl = photo.images.get(0);

        HashMap<Integer, PhotoSize> photoSizes = new PhotoSizeFactory().create();

        int layoutWidth = Utils.getScreenWidth();

        int coverImageWidth = layoutWidth;
        int coverImageHeight = (int) (Float.valueOf(layoutWidth) / Float.valueOf(photo.width) * Float.valueOf(photo.height));

        RelativeLayout.LayoutParams coverLayoutParams = new RelativeLayout.LayoutParams(layoutWidth, (int) (Float.valueOf(layoutWidth) / Float.valueOf(coverImageWidth) * Float.valueOf(coverImageHeight)));
        imageView.setLayoutParams(coverLayoutParams);
    }
}