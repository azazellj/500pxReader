package com.azazellj.a500pxreader.model;

import com.azazellj.a500pxreader.model.entity.PhotoSize;
import com.azazellj.a500pxreader.model.enums.Feature;
import com.azazellj.a500pxreader.model.factory.CategoryFactory;
import com.azazellj.a500pxreader.model.factory.PhotoSizeFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by azazellj on 18.03.16.
 */
public class ParamsLoader {

    private Map<String, Object> options;
    protected final String CUSTOMER_KEY = "3btne7jUalzOvrQjlaO609oskus6OsucD64xRmj2";

    private final String KEY_FEATURE = "feature";
    private final String KEY_ONLY = "only";
    private final String KEY_EXCLUDE = "exclude";
    private final String KEY_SORT = "sort";
    private final String KEY_SORT_DIRECTION = "sort_direction";
    private final String KEY_PAGE = "page";
    private final String KEY_RRP = "rpp";
    private final String KEY_IMAGE_SIZE = "image_size";
    private final String KEY_INCLUDE_STATES = "include_states";
    private final String KEY_TAGS = "tags";
    private final String KEY_CUSTOMER_KEY = "consumer_key";

    public ParamsLoader() {
        options = new HashMap<>();
        options.put(KEY_FEATURE, Feature.FRESH_TODAY.getName());
        options.put(KEY_ONLY, new CategoryFactory().getDefaultValue().getId());
        options.put(KEY_PAGE, 0);
        options.put(KEY_RRP, 20);
        options.put(KEY_IMAGE_SIZE, new PhotoSizeFactory().getDefaultValue().getId());

        options.put(KEY_INCLUDE_STATES, 1);
        options.put(KEY_CUSTOMER_KEY, CUSTOMER_KEY);
    }

    public ParamsLoader setFeature(Feature feature) {
        options.put(KEY_FEATURE, feature.getName());
        return this;
    }

    public ParamsLoader setPage(int page) {
        if (page < 1) {
            throw new IllegalArgumentException("Page cant`t be negative");
        }

        options.put(KEY_PAGE, page);
        return this;
    }

    public ParamsLoader setSortOrder(PhotoSortingOrderValue photoSortingOrderValue) {
        options.put(KEY_SORT, photoSortingOrderValue.getKey());
        return this;
    }

    public ParamsLoader setSortDirectionOrder(PhotoSortingDirectionValue sortDirectionOrder) {
        options.put(KEY_SORT_DIRECTION, sortDirectionOrder.getKey());
        return this;
    }

    public ParamsLoader setResultsPerPage(int resultsPerPage) {
        if (resultsPerPage < 1 || resultsPerPage > 100) {
            throw new IllegalArgumentException("Cant get more that 100 items per page");
        }

        options.put(KEY_SORT, resultsPerPage);
        return this;
    }

    public ParamsLoader setImageSize(PhotoSize photoSize) {
        options.put(KEY_IMAGE_SIZE, photoSize.getId());
        return this;
    }

    public Map<String, Object> build() {
        return this.options;
    }
}
