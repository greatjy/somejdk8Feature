package com.imooc.byennsix.resourceclosevs;

import jdk.internal.util.xml.impl.Input;
import org.junit.Test;

import java.io.*;

/**
 * @Author: wjy
 * @Date: 2020/3/1 17:11
 */
public class CopyFileTest {
    @Test
    public void testCopyFile() {
        File readFile = new File("D:\\java_intellij\\byennsix\\src\\main\\java\\com\\imooc\\byennsix\\domain\\enums\\Test.java");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        File output = new File("D:\\java_intellij\\byennsix\\src\\main\\java\\com\\imooc\\byennsix\\domain\\enums\\Test_1.txt");
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;


        try {
            fis = new FileInputStream(readFile);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            fos = new FileOutputStream(output);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void copyFileNew() {
        // 先定义输入输出路径
        String input = "D:\\java_intellij\\byennsix\\src\\main\\java\\com\\imooc\\byennsix\\domain\\enums\\Test.java";
        String output = "D:\\java_intellij\\byennsix\\src\\main\\java\\com\\imooc\\byennsix\\domain\\enums\\Test_2.txt";


        try (FileInputStream fis = new FileInputStream(input);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr);

             FileOutputStream fos = new FileOutputStream(output);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw);
             ) {
                 String line = null;
                while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
