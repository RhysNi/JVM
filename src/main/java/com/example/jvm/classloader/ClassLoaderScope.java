package com.example.jvm.classloader;

import static java.lang.System.*;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/7/15 1:13 上午
 * @Description
 */
public class ClassLoaderScope {
    public static void main(String[] args) {
        String bootPath= getProperty("sun.boot.class.path");
        out.println(bootPath.replaceAll(":", lineSeparator()));

        out.println("-------------------------");

        String extPath= getProperty("java.ext.dirs");
        out.println(extPath.replaceAll(":", lineSeparator()));

        out.println("-------------------------");

        String appPath= getProperty("java.class.path");
        out.println(appPath.replaceAll(":", lineSeparator()));
    }
}
