package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by SS on 13.11.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes c) {
        ImageReader reader= null;
        try {
            switch (c) {
                case BMP: reader = new BmpReader();
                break;
                case JPG: reader = new JpgReader();
                break;
                case PNG: reader = new PngReader();
                break;


            }
        } catch (Exception e) {
            throw new IllegalArgumentException(" ");
        }
        return reader;
    }
}
