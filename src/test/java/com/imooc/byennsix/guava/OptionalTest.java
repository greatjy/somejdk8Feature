package com.imooc.byennsix.guava;

import com.imooc.byennsix.domain.entity.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: wjy
 * @Date: 2020/3/1 20:28
 * 学习java8中的optional使用方法
 */
public class OptionalTest {

    @Test
    public void optionalTest() throws RuntimeException {
        /**
         * 三种创建Optional方法
         */

        //创建空的Optional对象
        Optional<Object> empty = Optional.empty();

        //创建不为空的Optional对象
        Optional<String> notnull = Optional.of("beijing university of posts and telecommunications");

        //创建任意Optional对象，可以接收null 或者 非null
        Optional<String> any = Optional.ofNullable("可以为空，也可以不为空");

        //1 判断当前Optional对象是否为空
        System.out.println(any.isPresent()+" "+empty.isPresent());

        notnull.ifPresent(System.out::println);
        System.out.println(empty.orElseGet(()->{return "helloword";}));
        // empty.orElseThrow(()->new RuntimeException());
        notnull.orElseThrow(()->new RuntimeException(">???"));


        List<Sku> cartList = null;
        Optional.ofNullable(cartList)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }
}
