package ru.kpfu.itis.jarfiles;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;

public class ImageGetter {

    private String imageUrl;
    private String path;
    private static int count;

    ImageGetter(String imageUrl, String path) {

        this.imageUrl = imageUrl;
        this.path = path;

    }

    public void downloadImage() {

        try {

            URL url = new URL(this.imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(this.imageUrl);
            stringBuilder.delete(0, 10);

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
}
