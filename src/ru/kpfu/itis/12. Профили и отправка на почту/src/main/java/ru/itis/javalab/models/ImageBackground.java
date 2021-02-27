package ru.itis.javalab.models;

import org.springframework.stereotype.Component;

public class ImageBackground {
    private String url;

    public ImageBackground(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
