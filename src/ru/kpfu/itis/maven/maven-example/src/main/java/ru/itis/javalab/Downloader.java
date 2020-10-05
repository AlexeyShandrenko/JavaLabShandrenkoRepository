package ru.itis.javalab;

import ru.itis.javalab.words.ThreadPool;
import com.beust.jcommander.JCommander;
import ru.itis.javalab.words.ImageGetter;

public class Downloader {

    public void download(String mode, String count, String url, String path) {

        String[] lonelyUrl = url.split(";");

        ThreadPool thread;

        if (mode.equals("multi-thread")) {
            thread = new ThreadPool(Integer.parseInt(count));
        } else {
            thread = new ThreadPool(1);
        }

        for (int i = 0; i < lonelyUrl.length; i++) {
            int finalI = i;
            Runnable task = () -> {
                ImageGetter im = new ImageGetter(lonelyUrl[finalI], path);
                im.downloadImage();
                System.out.println(Thread.currentThread().getName() + " завершил загрузку!");
            };
            thread.submit(task);
        }

    }

    public static void main(String[] argv) {

        Args args = new Args();

        JCommander.newBuilder()
            .addObject(args)
            .build()
            .parse(argv);

        String mode = args.mode;
        String count = args.count;
        String url = args.files;
        String path = args.folder;

        Downloader downloader = new Downloader();
        downloader.download(mode, count, url, path);

    }

}


