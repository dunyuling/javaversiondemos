package com.rc.openjdk11;

import java.util.List;

/**
 * @ClassName ListExample
 * @Description  新增 List API
 * @Author liux
 * @Date 19-4-2 上午12:47
 * @Version 1.0
 */
public class ListExample {

    public static void main(String[] args) {
        //Immutable Object
        List<String> list = List.of("1","2","3");
        //不可修改  java.lang.UnsupportedOperationException
//        list.set(0,"11");
//        list.clear();

        System.out.println(list);

        //旧的方式
        String[] oldWay = list.toArray(new String[0]);
        System.out.print("oldWay: ");
        for (int i = 0; i < oldWay.length; i++) {
            System.out.print(oldWay[i] + " ");
        }
        System.out.println();

        //新的方式 函数式编程
        //TODO 函数式编程
        String[] newWay = list.toArray(String[]::new);
        System.out.print("newWay: ");
        for (int i = 0; i < newWay.length; i++) {
            System.out.print(newWay[i] + " ");
        }
        System.out.println();

    }
}
