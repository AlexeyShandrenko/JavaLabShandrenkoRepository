package ru.itis.javalab.words;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageGetter {

    public String imageUrl;
    public String path;
    private static int count;

    protected ImageGetter(String imageUrl, String path) {

        this.imageUrl = imageUrl;
        this.path = path;

    }

    public void downloadImage() {

        try {

            URL url = new URL(this.imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            OutputStream outputStream = new FileOutputStream(this.path + "\\" + counter() + ".jpg");

            byte[] b = new byte[256];

            int length;

            while ((length = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, length);
            }

            inputStream.close();
            outputStream.close();
            connection.disconnect();

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public int counter() {
        count++;
        return count;
    }

    public static int getCount() {
        return count;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPath() {
        return path;
    }

    public static void setCount(int count) {
        ImageGetter.count = count;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
