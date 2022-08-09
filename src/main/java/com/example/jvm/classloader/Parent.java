package com.example.jvm.classloader;

import com.example.jvm.customerclassloader.RhysNiClassLoader;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/24 12:11 上午
 * @Description
 */
public class Parent {
    private static RhysNiClassLoader parent = new RhysNiClassLoader();

    private static class MyLoader extends ClassLoader {
        public MyLoader() {
            super(parent);
        }
    }
}
