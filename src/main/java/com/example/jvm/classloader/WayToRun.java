package com.example.jvm.classloader;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/23 10:31 下午
 * @Description
 */
public class WayToRun {
    public static void main(String[] args) {
        for (int i = 0; i < 10_0000L; i++) {
            r();
        }
        long start = System.currentTimeMillis();
        for (int j = 0; j < 10_0000L; j++) {
            r();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static void r() {
        for (long i = 0; i < 10_0000L; i++) {
            long j = i % 3;
        }
    }
}
