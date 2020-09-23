package ru.kpfu.itis.jarfiles;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;

public class ImageGetter {

    private String imageUrl;
    private static int count;

    public void downloadImage(String imageUrl, String path, String name) {

        try {

            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(imageUrl);
            stringBuilder.delete(0, 10);

            OutputStream outputStream = new FileOutputStream(path + "\\" + counter() + ".jpg");

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
