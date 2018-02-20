package com.travelsky.sh.studyzookeeper.zkclientDemo;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

public class SubscribeDataChanges {

    private static class ZKDataListener implements IZkDataListener{  
  
        public void handleDataChange(String dataPath, Object data) throws Exception {  
              
            System.out.println(dataPath+":"+data.toString());  
        }  
  
        public void handleDataDeleted(String dataPath) throws Exception {  
              
            System.out.println(dataPath);  
              
        }  
    }  
      
    public static void main(String[] args) throws InterruptedException {  
        //zk集群的地址  
    	//String loadClass="org/slf4j/impl/StaticLoggerBinder.class"
    	
        String ZKServers = "172.25.5.12:2181,172.25.5.134:2181,172.25.5.2:2181";  
        ZkClient zkClient = new ZkClient(ZKServers,10000,10000,new SerializableSerializer());  
        System.out.println("conneted ok!");  
        zkClient.subscribeDataChanges("/demopath", new ZKDataListener());  
        Thread.sleep(Integer.MAX_VALUE);  
          
    }  
}
