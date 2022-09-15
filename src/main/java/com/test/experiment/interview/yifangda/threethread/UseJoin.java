package com.test.experiment.interview.yifangda.threethread;

/**
 * @author tangrd
 * @since 2022/9/9 21:46
 */
public class UseJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            try {
                System.out.println("A");
                Thread.sleep(10);
                System.out.println("A");
                Thread.sleep(10);
                System.out.println("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread b = new Thread(() -> System.out.println("B"));
        Thread c = new Thread(() -> System.out.println("C"));

        for (int i = 2; i > 0; i--){
            a.start();
            a.join();
            b.start();
            b.join();
            c.start();
            c.join();
        }

    }
}
