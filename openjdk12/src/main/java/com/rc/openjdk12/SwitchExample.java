package com.rc.openjdk12;

import java.util.Calendar;

/**
 * @ClassName SwitchExample
 * @Description Switch 预览特性
 * @Author liux
 * @Date 19-4-3 上午11:33
 * @Version 1.0
 */
public class SwitchExample {

    //TODO IDE 尚不支持这种语法，需在CMD中运行，详见README
    public static void main(String[] args) {
        switch (Calendar.WEDNESDAY) {
            case Calendar.WEDNESDAY -> System.out.println(3);
            case Calendar.SUNDAY -> System.out.println(7);
            default -> System.out.println(0);
        }

        int result = switch (Calendar.WEDNESDAY) {
            case Calendar.WEDNESDAY -> 3;
            case Calendar.SUNDAY -> 7;
            default ->  0;
        };
        System.out.println("reuslt = " + result);

    }
}
