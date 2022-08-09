package com.example.jvm.gctuning;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/11/3 1:59 上午
 * @Description
 */
public class DeadLock {
    public static void main(String[] args) {

        final Object lock1 = new Object();
        final Object lock2 = new Object();

        //线程1
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "锁住了lock1");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "锁住了lock2");
                }
            }
        }).start();

        //线程2
        new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "锁住了lock2");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "锁住了lock1");
                }
            }
        }).start();
    }
}
