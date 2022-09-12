package com.amssolutions.similarproducts.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class ClientConfig {

	private static final String BASE_URL = "https://localhost:3001/";
	final static long TIMEOUT = 150;

	@Bean
	public Retrofit retrofit() {

		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

		Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient.connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
						.readTimeout(TIMEOUT, TimeUnit.MILLISECONDS).writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
						.retryOnConnectionFailure(true).build());

		return builder.build();
	}
}