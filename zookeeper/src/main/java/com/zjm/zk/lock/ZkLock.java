package com.zjm.zk.lock;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ZkLock implements Lock {
    //zk 客户端
    private ZooKeeper zk;
    //目录结构
    private String root="/locks";
    //锁名称
    private String lockName;
    //当前线程创先的序列node
    private ThreadLocal<String> nodeId=new ThreadLocal<>();
    //同步等待zkclient连接到了服务端
    private CountDownLatch connectedSignal = new CountDownLatch(1);
    //会话超时时间
    private final static int sessionTimeOut=3000;

    private final static byte[] data= new byte[0];
    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
