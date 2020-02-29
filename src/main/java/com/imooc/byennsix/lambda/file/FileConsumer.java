package com.imooc.byennsix.lambda.file;

/**
 * @Author: wjy
 * @Date: 2020/2/27 23:54
 */
@FunctionalInterface
public interface FileConsumer {
    /**
     * 函数时接口抽象方法
     * @param fileContent 文件内容字符串
     */
    void findHandler(String fileContent);
}
