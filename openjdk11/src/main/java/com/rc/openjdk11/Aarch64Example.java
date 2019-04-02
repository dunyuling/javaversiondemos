package com.rc.openjdk11;

import java.util.concurrent.TimeUnit;

/*
 * @ClassName Aarch64Example
 * @Description 改进 Aarch64 函数
 * @Author liux
 * @Date 19-4-1 下午3:58
 * @Version 1.0
 */
public class Aarch64Example {

    private static void math() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            Math.sin(i);
            Math.cos(i);
            Math.log(i);
        }
        //JDK8 7959ms
        //JDK11 1305ms
        long endTime = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        math();
    }
}
