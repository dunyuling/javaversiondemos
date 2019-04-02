package com.rc.openjdk11;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @ClassName DynamicTest
 * @Description 动态语言 API 测试
 * @Author liux
 * @Date 19-4-1 下午12:06
 * @Version 1.0
 */
public class DynamicTest {

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = lookup.findStatic(DynamicTest.class,"test", MethodType.methodType(void.class));
        methodHandle.invoke();
    }

    public static void test() {
        System.out.println("test");
    }


}
