package com.mxz.zuul.getway.filter;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Test01 {
    @Test
    public void test01() {
        Set<Integer> set = new HashSet<>();
        boolean add = set.add(1);
        System.out.println("add = " + add);
        boolean add2 = set.add(12);
        System.out.println("add2 = " + add2);
    }
}
