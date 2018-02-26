package com.open.micro.service.config;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.open.micro.service.config.interceptors.LoggerInteceptor;

import mousio.etcd4j.EtcdClient;

@Configuration
public class GlobalBean implements CommandLineRunner{
	
	@Bean(name = "loggerInteceptor")
	public LoggerInteceptor getLoggerInteceptor() {
		return new LoggerInteceptor();
	}
	
	@Bean("redisTemplate")
	public RedisTemplate<String, Object> redisTemplate( RedisConnectionFactory connectionFactory ) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		template.setValueSerializer( new JdkSerializationRedisSerializer() );
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		
		return template;
	}
	
	@Bean
    public LocaleResolver localeResolver() {
        RequestLocaleResolver rlr = new RequestLocaleResolver();
        return rlr;
    }
	
	@Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
	
	@Bean
	public EtcdClient etcdClient( @Value("${etcd.location}") String etcdLocations ) {
		String[] urls = etcdLocations.split(",");
		List<URI> uriList = new ArrayList<>();
		for (String url : urls) {
			uriList.add( URI.create(url) );
		}
		
		URI[] uris = new URI[uriList.size()];
		uriList.toArray( uris );
		
		EtcdClient etcdClient = new EtcdClient( uris );
		
		return etcdClient;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
	}
	
}