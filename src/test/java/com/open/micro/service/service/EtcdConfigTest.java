package com.open.micro.service.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.open.micro.service.BaseServiceTest;

import mousio.etcd4j.EtcdClient;
import mousio.etcd4j.responses.EtcdAuthenticationException;
import mousio.etcd4j.responses.EtcdException;
import mousio.etcd4j.responses.EtcdKeysResponse;

public class EtcdConfigTest extends BaseServiceTest{
	
	@Autowired private EtcdClient etcdClient;
	
	@Test
	public void testEtcd() throws IOException, EtcdException, EtcdAuthenticationException, TimeoutException {
		
		EtcdKeysResponse result = etcdClient.put("test", "bar").send().get();
		System.out.println( result.node.value );
		
		System.out.println( etcdClient.get("test").send().get().node.value );
		
	}

}
