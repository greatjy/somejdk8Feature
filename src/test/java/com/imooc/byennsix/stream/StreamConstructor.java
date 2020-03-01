package com.imooc.byennsix.stream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: wjy
 * @Date: 2020/3/1 13:23
 * 用来演示流的四种构建形式
 */
public class StreamConstructor {

    @Test
    public void streamFromValue() {
        Stream<Object> stream = Stream.of(1.5, "hello", 3, 4, 5);
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromArray() {
        int[] arr = {1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out :: println);
    }

    @Test
    public void fileStream() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("D:\\java_intellij\\byennsix\\src\\test\\java\\com\\imooc\\byennsix\\ByennsixApplicationTests.java"));
        lines.forEach(System.out::println);
    }

    /**
     *  根据函数来生成流的方法
     */
    @Test
    public void streamFromFunction(){
        // 通过iterator的方式实现一个流
        Stream.iterate(0, n -> n + 2)
                .limit(100)
                .forEach(System.out::println);

        //通过generator的方式实现一个流，与迭代不同的是 后一个流不会基于上一个流生成
        Stream.generate(Math :: random)
                .limit(100)
                .forEach(System.out :: println);

    }

}
