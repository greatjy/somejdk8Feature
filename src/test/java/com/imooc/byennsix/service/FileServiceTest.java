package com.imooc.byennsix.service;

import com.imooc.byennsix.lambda.file.FileService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author: wjy
 * @Date: 2020/2/28 0:06
 */
public class FileServiceTest {
    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();
        String url = "C:\\Users\\MrWang\\Desktop\\references.txt";
        fileService.fileHandle(url, System.out::println);
    }
}
