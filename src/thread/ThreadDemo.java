package thread;

public class ThreadDemo implements Runnable {

    private int type;

    public ThreadDemo() {

    }

    public ThreadDemo(int type) {

        this.type = type;

    }

    static int count_a;

    static int count_b;

    public synchronized void increase_a() {
        for (int i = 0; i < 100000; i++) {
            count_a++;
        }
    }

    public void increase_b() {
        synchronized (ThreadDemo.class) {
            for (int i = 0; i < 100000; i++) {
                count_b++;
            }
        }
    }


    @Override
    public void run() {

        if (type == 0) {
            increase_a();
        }

        if (type == 1) {
            increase_b();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        //锁定方法，相同对象的不同实例无效
        ThreadDemo demo = new ThreadDemo();
        Thread thb1 = new Thread(demo);
        Thread thb2 = new Thread(demo);

        //锁定类，相同对象的不同实例有效
        Thread tha1 = new Thread(new ThreadDemo(1));
        Thread tha2 = new Thread(new ThreadDemo(1));


        tha1.start();
        tha2.start();
        thb1.start();
        thb2.start();
        thb1.join();
        thb2.join();
        tha1.join();
        tha2.join();
        System.out.println(count_a);
        System.out.println(count_b);


    }

}
