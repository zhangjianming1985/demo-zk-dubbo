package com.zjm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis死锁问题：设置锁后，由于程序异常导致del指令没调用，锁不能释放，这样陷入死锁。 给锁加上过期时间可以解决。
 * redis单点问题：用集群解决， 如果集群中主节点挂掉，同时主节点中有把锁还没来得及同步到从节点，这样会导致系统中同样一把锁被两个客户端持有，导致不安全性。
 * 因此官方退出了Redlock算法解决这个问题，但是带来的网络消耗非常大
 */
@Component
public class RedisLocker{
    @Autowired
    private RedisTemplate redisTemplate;






    //上锁
    public void lock(String lockName,String lockValue) {
        while (true){
//           Boolean b= redisTemplate.opsForValue().setIfAbsent("lockName",LOCK_NAME);
            //解决死锁
            Boolean b  = redisTemplate.opsForValue().setIfAbsent(lockName,lockValue,30,TimeUnit.SECONDS);
           if (b){
               return;
           }else{
               System.out.println("循环等待中。。。。");
           }
        }
    }


    //解锁
    public void unlock(String lockName) {
        redisTemplate.delete(lockName);
    }




}
