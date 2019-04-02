package com.rc.openjdk11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName FilesExample
 * @Description Files 新增加的 API
 * @Author liux
 * @Date 19-4-2 上午12:09
 * @Version 1.0
 */
public class FilesExample {

    public static void main(String[] args) throws IOException {
        String path = "/tmp/jdk11_new_feature\n";
        Files.writeString(Path.of(path), "jdk11 new feature 中文", StandardCharsets.UTF_8);
        System.out.println(Files.readString(Paths.get(path), StandardCharsets.UTF_8));
    }
}
