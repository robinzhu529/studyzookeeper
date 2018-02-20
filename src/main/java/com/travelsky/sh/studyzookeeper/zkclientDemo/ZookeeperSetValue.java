package com.travelsky.sh.studyzookeeper.zkclientDemo;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

public class ZookeeperSetValue {  
    private static class ZKChildListener implements IZkChildListener{  
        /** 
         * handleChildChange： 用来处理服务器端发送过来的通知 
         * parentPath：对应的父节点的路径 
         * currentChilds：子节点的相对路径 
         */  
        public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {  
              
            System.out.println(parentPath);  
            System.out.println(currentChilds.toString());  
              
        }  
          
    }  
      
    public static void main(String[] args) throws InterruptedException {  
        //zk集群的地址  
        String ZKServers = "172.25.5.12:2181,172.25.5.134:2181,172.25.5.2:2181";  
        ZkClient zkClient = new ZkClient(ZKServers,10000,10000,new SerializableSerializer());  
        /** 
         * "/testUserNode" 监听的节点，可以是现在存在的也可以是不存在的 
         */  
        zkClient.writeData("/demopath","nihao");  
        Thread.sleep(Integer.MAX_VALUE);  
    }  
}  

