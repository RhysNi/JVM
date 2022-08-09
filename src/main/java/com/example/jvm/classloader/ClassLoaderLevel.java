//package com.example.jvm.classloader;
//
//import com.example.jvm.customerclassloader.RhysNiClassLoader;
//import sun.awt.HKSCS;
//import sun.net.spi.nameservice.dns.DNSNameService;
//import static java.lang.System.*;
//
///**
// * @author Rhys.Ni
// * @version 1.0
// * @date 2021/7/15 12:13 上午
// * @Description 类加载器
// */
//public class ClassLoaderLevel {
//    public static void main(String[] args) {
//        out.println(String.class.getClassLoader());
//        out.println(HKSCS.class.getClassLoader());
//        out.println(DNSNameService.class.getClassLoader());
//        out.println(ClassLoaderLevel.class.getClassLoader());
//        out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());
//        out.println(ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());
//        out.println(new RhysNiClassLoader().getParent());
//        out.println(ClassLoader.getSystemClassLoader());
//    }
//}
