package com.azazellj.a500pxreader.model.entity;

/**
 * Created by azazellj on 19.03.16.
 */
public class PhotoSize extends Entity {
    public String dimensions;
    public boolean isStandardCroppedSize;
    public int height = 0;
    public int width = 0;
    public boolean isHeightFixed;
    public boolean isWidthFixed;

    public PhotoSize(int id, String dimensions, boolean isStandardCroppedSize, int height, int width) {
        setId(id);
        setDimensions(dimensions);
        setStandardCroppedSize(isStandardCroppedSize);
        setHeight(height);
        setWidth(width);
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isStandardCroppedSize() {
        return isStandardCroppedSize;
    }

    public void setStandardCroppedSize(boolean isStandardCroppedSize) {
        this.isStandardCroppedSize = isStandardCroppedSize;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        boolean isHeightFixed = height != 0;
        setHeightFixed(isHeightFixed);

        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        boolean isWidthFixed = width != 0;
        setWidthFixed(isWidthFixed);

        this.width = width;
    }

    public boolean isHeightFixed() {
        return isHeightFixed;
    }

    public void setHeightFixed(boolean heightFixed) {
        isHeightFixed = heightFixed;
    }

    public boolean isWidthFixed() {
        return isWidthFixed;
    }

    public void setWidthFixed(boolean widthFixed) {
        isWidthFixed = widthFixed;
    }
}
