package com.imooc.byennsix.resourceclosevs;

import com.imooc.byennsix.lambda.file.FileConsumer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: wjy
 * @Date: 2020/2/27 23:52
 */
public class FileServiceResourceClose {

    /**
     * 通过url获取本地文件，通过函数式接口对本地文件进行处理
     * @param url
     * @param fileConsumer
     */
    public void fileHandle(String url, FileConsumer fileConsumer) throws IOException {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
        fis = new FileInputStream(url);
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);

        //读取文件内容变量
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        //读取到文件内容
        while ((line=br.readLine())!=null) {
            stringBuilder.append(line+"\n");
        }

        //使用函数式接口变量对文件进行处理
        fileConsumer.findHandler(stringBuilder.toString());}
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(br!=null){
                try {
                    br.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(isr != null) {
                try{
                    isr.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(fis != null) {
                try{
                    fis.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


    }


}
