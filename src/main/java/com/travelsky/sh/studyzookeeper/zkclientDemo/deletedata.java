package com.travelsky.sh.studyzookeeper.zkclientDemo;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

public class deletedata {
	public static void main(String[] args) {  
        //zk集群的地址  
        String ZKServers = "172.25.5.12:2181,172.25.5.134:2181,172.25.5.2:2181";  
        ZkClient zkClient = new ZkClient(ZKServers,10000,10000,new SerializableSerializer());  
        System.out.println("conneted ok!");  
        //删除单独一个节点，返回true表示成功  
        boolean e1 = zkClient.delete("/testUserNode");  
        //删除含有子节点的节点  
        boolean e2 = zkClient.deleteRecursive("/test");  
        //返回 true表示节点成功 ，false表示删除失败  
        System.out.println(e1);  
}  
}
