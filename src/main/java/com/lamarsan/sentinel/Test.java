package com.lamarsan.sentinel;

import com.lamarsan.sentinel.util.RedisSentinelUtil;

/**
 * className: Test
 * description: TODO
 *
 * @author hasee
 * @version 1.0
 * @date 2019/9/13 15:54
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        RedisSentinelUtil.setnx("hello", "world");
        while (true) {
            Thread.sleep(10000);
            String result = RedisSentinelUtil.get("hello");
            System.out.println(result);
        }
    }
}
