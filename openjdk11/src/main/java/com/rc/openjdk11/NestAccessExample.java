package com.rc.openjdk11;

import java.lang.reflect.Field;

/*
 * @ClassName NestAccessExample
 * @Description 基于嵌套的访问控制
 * @Author liux
 * @Date 19-4-1 上午11:04
 * @Version 1.0
 */
public class NestAccessExample {

    public static class X {

        void test() throws Exception {
            Y y = new Y();
            //源码级别私有访问
            y.y = 1;

            Field field = y.getClass().getDeclaredField("y");
            //jdk11之前必须设置下面一行，才能保证反射级别的私有访问权限和源码级别的私有访问权限相同
//            field.setAccessible(true);
            field.setInt(y, 2);
        }
    }

    private static class Y {
        private int y;
    }

    class Z {
        private int z = 100;
    }

    public static void main(String[] args) throws Exception {
        //面试题
        //访问嵌套类
        //1
//        int z = new NestAccessExample().new Z().z;
        //2
//        NestAccessExample nestAccessExample = new NestAccessExample();
//        int z = nestAccessExample.new Z().z;

        new X().test();
    }

}
