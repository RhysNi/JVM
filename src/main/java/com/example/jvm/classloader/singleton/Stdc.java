package com.example.jvm.classloader.singleton;
/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/29 10:08 下午
 * @Description
 */
public class Stdc {
    private static volatile Stdc INSTANCE;

    public static Stdc getInstance() {
        if (INSTANCE == null) {
            synchronized (Stdc.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Stdc();
                }
            }
        }
        return INSTANCE;
    }

    private Stdc() {

    }
}
