package com.example.jvm.classloader;

import static java.lang.System.*;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/15 1:05 上午
 * @Description
 */
public class ParentAndChild {
    public static void main(String[] args) {
        out.println(ParentAndChild.class.getClassLoader());
        out.println(ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        out.println(ParentAndChild.class.getClassLoader().getParent());
        out.println(ParentAndChild.class.getClassLoader().getParent().getParent());
    }
}
