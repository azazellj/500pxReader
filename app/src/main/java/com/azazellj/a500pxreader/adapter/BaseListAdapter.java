package com.azazellj.a500pxreader.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.azazellj.a500pxreader.adapter.holder.BaseListItemViewHolder;
import com.azazellj.a500pxreader.model.entity.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azazellj on 20.03.16.
 */
public abstract class BaseListAdapter<E extends Entity, V extends View, VH extends BaseListItemViewHolder<E, V>> extends RecyclerView.Adapter<VH> {
    private List<E> mItems = new ArrayList<>();

    public void setItems(List<E> items) {
        this.mItems = items;
    }

    public void addItems(List<E> items) {
        this.mItems.addAll(items);
    }

    public E getItem(int position) {
        return this.mItems.get(position);
    }

    public void deleteAll() {
        this.mItems.clear();
    }

    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindViewHolder(final VH holder, final int position);

    @Override
    public long getItemId(int position) {
        return this.mItems.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }
}
