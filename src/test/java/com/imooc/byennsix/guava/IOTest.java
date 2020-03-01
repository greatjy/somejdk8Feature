package com.imooc.byennsix.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * @Author: wjy
 * @Date: 2020/3/2 0:12
 * 使用流source 和 汇sink 对文件进行操作
 */
public class IOTest {
    public void testCopy() throws IOException {
        // 创建对应source 和 sink
        CharSource charSource = Files.asCharSource(new File("D:\\java_intellij\\byennsix\\src\\test\\java\\com\\imooc\\byennsix\\guava\\IOTest.java"), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File("D:\\java_intellij\\byennsix\\src\\test\\java\\com\\imooc\\byennsix\\guava\\IOTest.txt"), Charsets.UTF_8);
        charSource.copyTo(charSink);

        //copy

    }
}
