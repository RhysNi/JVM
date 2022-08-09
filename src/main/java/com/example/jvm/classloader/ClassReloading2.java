package com.example.jvm.classloader;

import java.io.*;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/24 1:24 上午
 * @Description
 */
public class ClassReloading2 {
    private static class MyLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            File file = new File("/Users/rhys/IdeaProjects/jvm/target/classes/" + name.replace(".", "/").concat(".class"));
            if (!file.exists()) {
                return super.loadClass(name);
            }
            try {
                InputStream is = new FileInputStream(file);
                byte[] bytes = new byte[is.available()];
                is.read(bytes);
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyLoader myLoader=new MyLoader();
        Class clazz1 = myLoader.loadClass("com.example.jvm.Hello");
        System.out.println(clazz1.hashCode());

        myLoader=new MyLoader();
        Class clazz2 = myLoader.loadClass("com.example.jvm.Hello");
        System.out.println(clazz2.hashCode());
        System.out.println(clazz1 == clazz2);
    }
}
