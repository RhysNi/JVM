package com.example.jvm.fiber;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/11/23 1:02 上午
 * @Description 此程序需要JDK13
 */
public class HelloFiber {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Fiber<Void> fiber = new Fiber<Void>(new SuspendableRunnable() {
                @Override
                public void run() throws SuspendExecution, InterruptedException {
                    calc();
                }
            });
            fiber.start();


//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    calc();
//                }
//            });
//            thread.start();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void calc() {
        int result = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 200; j++) {
                result += i;
            }
        }
    }
}