package ru.kpfu.itis.jarfiles;

import com.beust.jcommander.JCommander;
import ru.kpfu.itis.pool.ThreadPool;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Args args = new Args();

        // JCommander.newBuilder()
        //     .addObject(args)
        //     .build()
        //     .parse(argv);

        String mode = args[0];
        String count = args[1];
        String url = args[2];
        String path = args[3];

        ThreadPool thread;

        if (mode.equals("multi-thread")) {
            thread = new ThreadPool(Integer.parseInt(count));
        } else {
            thread = new ThreadPool(1);
        }

        System.out.println("count is " + count);

        String[] lonelyUrl = url.split(";");
        System.out.println("length is " + lonelyUrl.length);

        for (int i = 0; i < lonelyUrl.length; i++) {
            System.out.println(lonelyUrl[i]);
            int finalI = i;
            Runnable task = () -> {
                ImageGetter im = new ImageGetter(lonelyUrl[finalI], path);
                im.downloadImage();
                System.out.println(Thread.currentThread().getName() + " завершил загрузку!");
            };
            thread.submit(task);
        }




//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter path");
//        String path = sc.nextLine();
//        System.out.println("enter count of threads");
//        int count = sc.nextInt();
//
//
//        ThreadPool thread = new ThreadPool(count);
//
//
//        String url = "https://www.meme-arsenal.com/memes/bc3847731228057022e85e26065dd81d.jpg;https://avatars.mds.yandex.net/get-pdb/216365/d5fdcac3-d7c6-41c6-b61c-47ef38e704a8/s1200?webp=false;https://funik.ru/wp-content/uploads/2018/10/abd9deab7e57674e9fd6.jpg";
//
//
//        String[] lonelyUrl = url.split(";");
//
//        for (int i = 0; i < lonelyUrl.length; i++) {
//            System.out.println(lonelyUrl[i]);
//            int finalI = i;
//            Runnable task = () -> {
//                ImageGetter im = new ImageGetter(lonelyUrl[finalI], path);
//                im.downloadImage();
//                System.out.println(Thread.currentThread().getName() + " завершил загрузку!");
//            };
//            thread.submit(task);
//        }

    }

}
