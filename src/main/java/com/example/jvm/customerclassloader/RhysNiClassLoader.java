package com.example.jvm.customerclassloader;


import com.example.jvm.Hello;

import java.io.*;
import java.lang.reflect.Method;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/15 1:59 上午
 * @Description
 */
public class RhysNiClassLoader extends  ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file=new File("/Users/rhys/IdeaProjects/jvm/target/classes/",name.replace(".","/").concat(".class"));
        try {
            FileInputStream fileInputStream= new FileInputStream(file);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            int b = 0;
            while ((b=fileInputStream.read()) !=-1){
                baos.write(b);
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
        RhysNiClassLoader classLoader=new RhysNiClassLoader();
        Class clazz=classLoader.findClass("com.example.jvm.Hello");
        Object hello= clazz.newInstance();
        Method method=clazz.getMethod("print");
        method.invoke(hello);
        System.out.println(classLoader.getClass().getClassLoader());
        System.out.println(classLoader.getParent());
    }


}