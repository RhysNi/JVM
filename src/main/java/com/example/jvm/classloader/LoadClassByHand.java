package com.example.jvm.classloader;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/15 1:25 上午
 * @Description
 */
public class LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = LoadClassByHand.class.getClassLoader().loadClass("com.example.jvm.classloader.ClassLoaderLevel");
        System.out.println(clazz.getName());
    }
}
