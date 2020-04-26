package com.semaneiro.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

@Configuration 
public class HttpClientConfig {
	
	 
	
	public ClientHttpRequestFactory createClientHttpRequestFactory() throws Exception {

	        HttpClient httpClient = HttpClients.createDefault();
	        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
	        httpComponentsClientHttpRequestFactory.setReadTimeout(30000);
	        httpComponentsClientHttpRequestFactory.setConnectTimeout(30000);
	        httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(30000);
	        return httpComponentsClientHttpRequestFactory;

	    }
	

}
