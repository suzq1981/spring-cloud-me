package com.badou.cloud.ums.config;

import com.badou.cloud.ums.interceptor.FeignAddRequestHeaderInterceptor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import feign.Logger;
import feign.codec.Encoder;

@Configuration
public class FeignConfiguration {
	
	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public FeignAddRequestHeaderInterceptor addRequestHeaderInterceptor(){
		return new FeignAddRequestHeaderInterceptor();
	}

	@Bean
    @Primary
    @Scope("prototype")
	public Encoder feignEncoder() {
		return new SpringMultipartEncoder(new SpringEncoder(messageConverters));
	}
}
