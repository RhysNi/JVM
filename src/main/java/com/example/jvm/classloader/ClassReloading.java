package com.example.jvm.classloader;

import com.example.jvm.customerclassloader.RhysNiClassLoader;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/24 1:24 上午
 * @Description
 */
public class ClassReloading {
    public static void main(String[] args) throws ClassNotFoundException {
        RhysNiClassLoader classLoader = new RhysNiClassLoader();
        Class clazz1 = classLoader.loadClass("com.example.jvm.Hello");
        classLoader = null;
        System.out.println(clazz1.hashCode());
        classLoader = null;
        classLoader = new RhysNiClassLoader();
        Class clazz2 = classLoader.loadClass("com.example.jvm.Hello");
        System.out.println(clazz2.hashCode());
        System.out.println(clazz1 == clazz2);
    }
}
