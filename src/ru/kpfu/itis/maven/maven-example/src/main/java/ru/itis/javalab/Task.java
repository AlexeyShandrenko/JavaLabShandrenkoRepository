package ru.itis.javalab;

import ru.itis.javalab.words.ImageGetter;

public class Task implements Runnable {

    private String url;
    private String path;

    Task(String url, String path) {

        this.url = url;
        this.path = path;

    }

    @Override
    public void run() {
        ImageGetter im = new ImageGetter(this.url, this.path);
        im.downloadImage();
        System.out.println(Thread.currentThread().getName() + " завершил загрузку!");
    }

    public String getPath() {
        return path;
    }

    public String getUrl() {
        return url;
    }
}
