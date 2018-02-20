package com.travelsky.sh.studyzookeeper;

import java.util.concurrent.TimeUnit;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import junit.framework.TestCase;

public class LockPathTest extends TestCase{
public void testDistubuteLock() {
	RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
	CuratorFramework client = CuratorFrameworkFactory.newClient("172.25.5.12:2181,172.25.5.134:2181,172.25.5.2:2181", retryPolicy);
	InterProcessMutex    lock = new InterProcessMutex(client, "testpath");
	try {
		if ( lock.acquire(3000, TimeUnit.MILLISECONDS) ) 
		{
		   try 
		    {
		      	
		    }
		    finally
		    {
		        lock.release();
		    }
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
