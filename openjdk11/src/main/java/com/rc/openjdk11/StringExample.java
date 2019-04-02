package com.rc.openjdk11;

/**
 * @ClassName StringExample
 * @Description String 新增 API
 * @Author liux
 * @Date 19-4-2 上午12:23
 * @Version 1.0
 */
public class StringExample {

    public static void main(String[] args) {
        //三种空格unicode(\u00A0,\u0020,\u3000)表示的区别
        //1.不间断空格\u00A0,主要用在office中,让一个单词在结尾处不会换行显示,快捷键ctrl+shift+space ;
        //2.半角空格(英文符号)\u0020,代码中常用的;
        //3.全角空格(中文符号)\u3000,中文文章中使用;
        //strip 针对2,3,' '有效
        //trim只针对2和' '有效
        String example = " \u3000hello jdk11\u00A0 ";
        String empty = "\u0020";
        System.out.println("原始字符串：" + example);

        //对比trim和strip
        System.out.println("<trim -> 删除字符串的头尾空白符>" + example.trim());
        System.out.println("<strip -> 删除字符串的头尾空白符>" + example.strip());
        System.out.println("<strip -> 删除字符串的头部空白符>" + example.stripLeading());
        System.out.println("<strip -> 删除字符串的尾部空白符>" + example.stripTrailing());

        //对比isBlank 和 isEmpty
        System.out.println("<isBlank -> 是否为空或者仅包含空格>" + empty.isBlank());
        System.out.println("<isEmpty -> 是否为空>" + empty.isEmpty());

        //lines
        String lines = "1\n2\n3";
        lines.lines().forEach(System.out::println);

        //repeat
        String str = "*";
        System.out.println(str.repeat(30));



    }
}
