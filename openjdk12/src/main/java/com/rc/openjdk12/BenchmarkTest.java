package com.rc.openjdk12;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName BenchmarkTest
 * @Description JMH 使用方法
 * @Author liux
 * @Date 19-4-3 上午10:37
 * @Version 1.0
 */
@Fork(2)
@Threads(8)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchmarkTest {

    @Benchmark
    public void stringAdd() {
        String a = "";

        for (int i = 0; i < 10; i++) {
            a += i;
        }

        //TODO 不要输出内容，否则影响基准测试
//        System.out.println();
    }

    @Benchmark
    public void testStringBuilderAdd() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(i);
        }
    }

    public static void main(String[] args) {
        Options options = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
//                .output("/tmp/benchmark.log")
                .build();
        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }

}
