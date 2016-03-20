package com.azazellj.a500pxreader.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.azazellj.a500pxreader.model.entity.Entity;
import com.azazellj.a500pxreader.utils.Utils;

/**
 * Created by azazellj on 20.03.16.
 */
public class BaseListItemViewHolder<E extends Entity, V extends View> extends RecyclerView.ViewHolder {
    public BaseListItemViewHolder(V view) {
        super(view);

        RecyclerView.LayoutParams mParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mParams.setMargins(0, 0, 0, Utils.convertDpToPx(10));
        view.setLayoutParams(mParams);
    }

    public V getView() {
        return (V) this.itemView;
    }

    public void updateView(E entity) {
    }
}