package com.zjm;

import com.zjm.bean.Stock;
import com.zjm.redis.RedisLocker;
import com.zjm.redis.redisson.RedissonLockUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZookeeperApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestStock {
    private static String lockName="lock-name";

    private static String lockValue="lock-value";
    @Autowired
    public RedisLocker redisLocker;

    CountDownLatch countDownLatch = new CountDownLatch(2);
    public class StockThread implements Runnable{
        public void run(){
//            redisLocker.lock(lockName,lockValue);
            RedissonLockUtil.lock(lockName);
            boolean b = new Stock().reduceStock();
//            redisLocker.unlock(lockName);
            RedissonLockUtil.unlock(lockName);
            if (b){
                System.out.println(Thread.currentThread().getName()+":减少库存成功");
            }else{
                System.out.println(Thread.currentThread().getName()+":减少库存失败");
            }
            countDownLatch.countDown();
        }
    }

    @Test
    public void test(){
        new Thread(new StockThread(),"线程1").start();
        new Thread(new StockThread(),"线程2").start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //单元测试无法测试多线程！！！！需要借助 可以利用三方工具：GroboUtils。
//        new Thread(new StockThread(redisLock),"线程1").start();
//        new Thread(new StockThread(redisLock),"线程2").start();
/*        redisLock.lock();
        boolean b = new Stock().reduceStock();
        redisLock.unlock();
        if (b){
            System.out.println(Thread.currentThread().getName()+":减少库存成功");
        }else{
            System.out.println(Thread.currentThread().getName()+":减少库存失败");
        }*/
    }
}
