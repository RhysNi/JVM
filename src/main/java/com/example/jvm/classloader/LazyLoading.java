package com.example.jvm.classloader;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/23 11:52 下午
 * @Description
 */
public class LazyLoading {
    public static void main(String[] args) throws ClassNotFoundException {
//        P p;
//        X x=new X();
//        System.out.println(P.i);
//        System.out.println(P.j);
        Class.forName("com.example.jvm.classloader.LazyLoading$P");
    }

    public static class P{
        final static int i =8;
        static int j = 9;
        static {
            System.out.println("PPPP");
        }
    }

    public static class X extends P{
        static {
            System.out.println("XXXX");
        }
    }
}
