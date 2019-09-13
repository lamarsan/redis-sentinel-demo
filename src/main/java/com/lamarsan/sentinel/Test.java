package com.lamarsan.sentinel;

import com.lamarsan.sentinel.util.RedisUtil;

/**
 * className: Test
 * description: TODO
 *
 * @author hasee
 * @version 1.0
 * @date 2019/9/13 15:54
 */
public class Test {
    public static void main(String[] args) {
        String result = RedisUtil.get("hello");
        System.out.println(result);
    }
}
