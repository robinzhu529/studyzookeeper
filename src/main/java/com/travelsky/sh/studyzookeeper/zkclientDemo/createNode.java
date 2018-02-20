package com.travelsky.sh.studyzookeeper.zkclientDemo;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;

public class createNode {

	  
    public static void main(String[] args) {  
        //zk集群的地址  
        String ZKServers = "172.25.5.12:2181,172.25.5.134:2181,172.25.5.2:2181";  
        ZkClient zkClient = new ZkClient(ZKServers,10000,10000,new SerializableSerializer());  
          
        System.out.println("conneted ok!");  
          
        User user = new User();  
        user.setId(1);  
        user.setName("testUser");  
        /** 
         * "/testUserNode" :节点的地址 
         * user：数据的对象 
         * CreateMode.PERSISTENT：创建的节点类型 
         */  
        String path = zkClient.create("/testUserNode", user, CreateMode.PERSISTENT);  
        //输出创建节点的路径  
        System.out.println("created path:"+path);  
    }  
}
