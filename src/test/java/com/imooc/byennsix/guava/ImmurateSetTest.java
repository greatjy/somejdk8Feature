package com.imooc.byennsix.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author: wjy
 * @Date: 2020/3/1 22:48
 */
public class ImmurateSetTest {
    @Test
    public void immuareCollectionTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //1 通过不可变对象的copyOf方法直接将一个现有的集合转变成ImmutableXXX结合
        ImmutableList<Integer> immutableList1 = ImmutableList.copyOf(list);

        //2 通过给不可变集合加值的方法初始化一个不可变集合
        ImmutableList<Integer> immutableList = ImmutableList.of(1,2,3);

        //3 通过builder().add()/addAll().build()方法为不可变集合进行元素追加
        ImmutableList<Object> buildimmutableList = ImmutableList.builder().add(1).addAll(list).add(34).build();
    }

    @Test
    public void multiSetTest() {
        Multiset<String> multiset = HashMultiset.create();
        String s = "上有六龙回日之高标，下有冲波逆折之回川";
        String[] chars = s.split("");
        Arrays.stream(chars).forEach(multiset::add);

        System.out.println(multiset.size());
        System.out.println(multiset.count("有"));
    }

    /**
     *   Sets工具类的常用方法
     *   并集/交集/差集/分解集合中的子集/两个集合的笛卡尔积
     *   Lists工具类常用方法
     *   反转/拆分
     */
    private static final Set set1 = Sets.newHashSet(1,2);
    private static final Set set2 = Sets.newHashSet(4,5);
    @Test
    public void unionTest() {

        Set<Integer> set = Sets.union(set1, set2);
        System.out.println(JSON.toJSONString(set,true));
    }

    @Test
    public void interTest() {
        Set<Integer> set = Sets.intersection(set1,set2);
        System.out.println(JSON.toJSONString(set,true));
    }

    @Test
    public void diffTest() {
        Set<Integer> set = Sets.difference(set1, set2);
        System.out.println(JSON.toJSONString(set,true));
    }

    /**
     * set中的子集，返回set《set》
     */
    public void powerSetTest() {
        Set set = Sets.powerSet(set1);

    }

    @Test
    public void cartsanProcuctTest() {
        Set<List<Integer>>  set = Sets.cartesianProduct(set1, set2);
        System.out.println(JSON.toJSONString(set,true));
     }

     List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7);
    @Test
    public void partitionTest() {
         List<List<Integer>> partition = Lists.partition(list, 3);
         System.out.println(JSON.toJSONString(partition,true));
     }

}

