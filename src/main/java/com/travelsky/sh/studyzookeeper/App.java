package com.travelsky.sh.studyzookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{private static Logger logger=Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	logger.info("hello this is app");
    	RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    			CuratorFramework client = CuratorFrameworkFactory.newClient("172.25.5.12:2181,172.25.5.134:2181,172.25.5.2:2181", retryPolicy);
    			client.start();
    			try {
					client.create().forPath("/my", "nihao".getBytes());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    }
}
