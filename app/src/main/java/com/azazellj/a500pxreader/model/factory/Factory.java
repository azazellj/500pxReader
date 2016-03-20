package com.azazellj.a500pxreader.model.factory;

import java.util.HashMap;

/**
 * Created by azazellj on 19.03.16.
 */
public abstract class Factory<K, V> {
    public abstract K getDefaultKey();

    public abstract HashMap<K, V> create();

    public V getDefaultValue() {
        return create().get(getDefaultKey());
    }
}
