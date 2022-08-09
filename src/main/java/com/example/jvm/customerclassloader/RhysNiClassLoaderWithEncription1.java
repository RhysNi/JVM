package com.example.jvm.customerclassloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/15 1:59 上午
 * @Description
 */

public class RhysNiClassLoaderWithEncription1 extends ClassLoader {
    public static int seed = 0B10110110;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file=new File("/Users/rhys/IdeaProjects/jvm/target/classes/",name.replace(".","/").concat(".rhysclass"));
        try {
            FileInputStream fileInputStream= new FileInputStream(file);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            int b = 0;
            while ((b=fileInputStream.read()) !=-1){
                //根据seed解密
                baos.write(b ^ seed);
            }
            byte[] bytes= baos.toByteArray();
            baos.close();
            fileInputStream.close();
            return defineClass(name,bytes,0,bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws Exception {
        //加密
        encFile("com.example.jvm.Hello");

        RhysNiClassLoaderWithEncription1 classLoader=new RhysNiClassLoaderWithEncription1();
        Class clazz=classLoader.findClass("com.example.jvm.Hello");

        Object hello= clazz.newInstance();
        Method method=clazz.getMethod("print");
        method.invoke(hello);

        System.out.println(classLoader.getClass().getClassLoader());
        System.out.println(classLoader.getParent());
    }

    private static void encFile(String name) throws Exception {
        File file = new File("/Users/rhys/IdeaProjects/jvm/target/classes/",name.replace(".", "/").concat(".class"));
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/rhys/IdeaProjects/jvm/target/classes/",name.replace(".", "/").concat(".rhysclass")));
        int b = 0;
        while ((b = fileInputStream.read()) != -1) {
            fileOutputStream.write(b ^ seed);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}