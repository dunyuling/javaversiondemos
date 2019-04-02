package com.rc.openjdk11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
 * @ClassName LocalVarExample
 * @Description Lambda参数的本地变量语法
 * @Author liux
 * @Date 19-4-1 下午5:01
 * @Version 1.0
 */
public class LocalVarExample {

    /*
     * @Author liux
     * @Description Java8特性: lambda 表达式语法
     * @Date 19-4-1 下午5:02
     * @param
     * @return void
     **/
    private static void lambdaInJava8() {
        //参数列表, ->, 函数体
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before java8");
            }
        }).start();

        new Thread(() -> System.out.println("in java8")).start();

        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(a -> {
            System.out.println("lambda in java8");
            System.out.println(a);
        });
        System.out.println();
        list.forEach(System.out::println);
    }

    /*
     * @Author liux
     * @Description Java10 新特性: 局部变量类型推断
     * @Date 19-4-1 下午5:11
     * @param
     * @return void
     **/
    private static void varInJava10() {
        int var = 3;

        var i = 10;   //int
        var str = "hello"; //String
        var list = new ArrayList<String>(); //ArrayList<String>
        var map = Map.of(1, "a", 2, "b");
        for (var entry : map.entrySet()) {
            System.out.println(entry);
        }


        // i = "a"; wrong  i的类型已经被确定为int
        // var a ; wrong   声明的时候必须初始化
    }

    class ErrorUseVar {
//        var i = 10； wrong,不是局部变量不允许

        //不能用作返回值
        /*var f1() {
            return 10;
        }*/

        //不能用作函数参数
        /*int f2(var x) {
            return 19;
        }*/
    }

    /*
     * @Author liux
     * @Description Java11 新特性：lambda表达式可以使用var来标识变量
     * @Date 19-4-1 下午5:24
     * @param
     * @return void
     **/
    private static void lambdaWithVarInJava11() {
        List<Integer> nums = Arrays.asList(4, 1, 2, 3);
        nums.sort((var o1, var o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else {
                return o1 > o2 ? 1 : -1;
            }
        });
        System.out.println(nums);
    }


    public static void main(String[] args) {
//        lambdaInJava8();
//        varInJava10();
        lambdaWithVarInJava11();
    }
}
