package design_patterns.SingleTon;

import java.util.Map;

public class ThreadTest implements Runnable {
    @Override
    public void run() {

        Map map = SingleTon_Lazy.getInstance();
        System.out.println();

    }


    public static void main(String[] args) {

        Thread th1 = new Thread(new ThreadTest());
        Thread th2 = new Thread(new ThreadTest());


        th1.start();
        th2.start();


    }
}
