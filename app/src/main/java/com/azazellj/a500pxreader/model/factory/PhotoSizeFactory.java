package com.azazellj.a500pxreader.model.factory;

import com.azazellj.a500pxreader.model.entity.PhotoSize;

import java.util.HashMap;

/**
 * Created by azazellj on 19.03.16.
 */
public class PhotoSizeFactory extends Factory<Integer, PhotoSize> {
    @Override
    public HashMap<Integer, PhotoSize> create() {
        HashMap<Integer, PhotoSize> photoSizes = new HashMap<>();

        photoSizes.put(1, new PhotoSize(1, "70px x 70px", true, 70, 70));
        photoSizes.put(2, new PhotoSize(2, "140px x 140px", true, 140, 140));
        photoSizes.put(3, new PhotoSize(3, "280px x 280px", true, 280, 280));
        photoSizes.put(100, new PhotoSize(100, "100px x 100px", true, 100, 100));
        photoSizes.put(200, new PhotoSize(200, "200px x 200px", true, 200, 200));
        photoSizes.put(440, new PhotoSize(440, "440px x 440px", true, 440, 440));
        photoSizes.put(600, new PhotoSize(600, "600px x 600px", true, 600, 600));

        photoSizes.put(4, new PhotoSize(4, "900px on the longest edge", false, 0, 900));
        photoSizes.put(5, new PhotoSize(5, "1170px on the longest edge", false, 0, 1170));
        photoSizes.put(6, new PhotoSize(6, "1080px high", false, 0, 1080));
        photoSizes.put(20, new PhotoSize(20, "300px high", false, 300, 0));
        photoSizes.put(21, new PhotoSize(21, "600px high", false, 600, 0));
        photoSizes.put(30, new PhotoSize(30, "256px on the longest edge", false, 0, 256));
        photoSizes.put(31, new PhotoSize(31, "450px high", false, 450, 0));
        photoSizes.put(1080, new PhotoSize(1080, "1080px on the longest edge", false, 0, 1080));
        photoSizes.put(1600, new PhotoSize(1600, "1600px on the longest edge", false, 0, 1600));
        photoSizes.put(2048, new PhotoSize(2048, "2048px on the longest edge", false, 0, 2048));

        return photoSizes;
    }

    @Override
    public Integer getDefaultKey() {
        return 31;
    }

    // TODO: 19.03.16 make methods for adequate photo sizes in different situations
}
