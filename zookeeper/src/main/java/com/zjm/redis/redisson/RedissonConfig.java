package com.zjm.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    /**
     * RedissonClient,单机模式
     *
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://" + host + ":" + port);
        singleServerConfig.setTimeout(timeout);
        singleServerConfig.setDatabase(database);
        if (password != null && !"".equals(password)) { //有密码
            singleServerConfig.setPassword(password);
        }
        return Redisson.create(config);
    }

    @Bean
    public RedissonLocker redissonLocker(RedissonClient redissonClient) {
        RedissonLocker locker = new RedissonLocker(redissonClient);
        //设置LockUtil的锁处理对象
        RedissonLockUtil.setLocker(locker);
        return locker;
    }
}
