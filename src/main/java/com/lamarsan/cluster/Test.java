package com.lamarsan.cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * className: Test
 * description: TODO
 *
 * @author hasee
 * @version 1.0
 * @date 2019/9/16 20:31
 */
public class Test {
    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(1);
        // 最大空闲数
        poolConfig.setMaxIdle(1);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("******", 7000));
        nodes.add(new HostAndPort("******", 7001));
        nodes.add(new HostAndPort("******", 7002));
        nodes.add(new HostAndPort("******", 7003));
        nodes.add(new HostAndPort("******", 7004));
        nodes.add(new HostAndPort("******", 7005));
        String password = "******";
        JedisCluster cluster = new JedisCluster(nodes, 10000, 1000, 1000, password, poolConfig);
        cluster.setnx("foo","bar");
        System.out.println(cluster.get("foo"));
        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
