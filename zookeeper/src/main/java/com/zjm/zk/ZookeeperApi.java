package com.zjm.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class ZookeeperApi {
    public void test()throws Exception{
        //创建zookeeper连接
        ZooKeeper zooKeeper=new ZooKeeper("127.0.0.1:5181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("触发了"+watchedEvent.getType()+"的事件");
            }
        });
        //创建父节点
/*        String path = zooKeeper.create("/mynode","my-node-value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);*/

        //创建子节点
/*        String childrenPath = zooKeeper.create("/mynode/childrennode","children-value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(childrenPath);*/

        //获取节点中的值（父节点和子节点）
        byte[] data = zooKeeper.getData("/mynode",false,null);
        System.out.println(new String(data));

        List<java.lang.String> children =zooKeeper.getChildren("/mynode",false);
        for (String child :children){
            System.out.println("child = "+child);
        }
        //修改节点值
        Stat stat = zooKeeper.setData("/mynode","mynodeupdate".getBytes(),-1);
        System.out.println("update stat = "+stat);
        //判断某个节点是否存在
        Stat exists = zooKeeper.exists("/mynode",false);
        System.out.println("exists stat = "+exists);
        //删除节点
        zooKeeper.delete("/mynode/childrennode",-1);

    }
}
