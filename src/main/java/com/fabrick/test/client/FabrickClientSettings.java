package com.fabrick.test.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FabrickClientSettings {

	@Value("${fabrick.api-value}")
	private String API_VALUE;

	@Value("${fabrick.auth-schema}")
	private String AUTH_SCHEMA;

	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate requestTemplate) {
				requestTemplate.header("Api-Key", API_VALUE);
				requestTemplate.header("Auth-Schema", AUTH_SCHEMA);
			}
		};
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

}
