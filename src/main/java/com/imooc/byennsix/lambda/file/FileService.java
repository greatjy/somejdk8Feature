package com.imooc.byennsix.lambda.file;

import java.io.*;

/**
 * @Author: wjy
 * @Date: 2020/2/27 23:52
 */
public class FileService {

    /**
     * 通过url获取本地文件，通过函数式接口对本地文件进行处理
     * @param url
     * @param fileConsumer
     */
    public void fileHandle(String url, FileConsumer fileConsumer) throws IOException {
        //创建文件输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url)));

        //读取文件内容变量
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        //读取到文件内容
        while ((line=bufferedReader.readLine())!=null) {
            stringBuilder.append(line+"\n");
        }

        //使用函数式接口变量对文件进行处理
        fileConsumer.findHandler(stringBuilder.toString());

    }


}
