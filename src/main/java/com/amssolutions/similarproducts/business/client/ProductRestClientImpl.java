package com.amssolutions.similarproducts.business.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amssolutions.similarproducts.controller.client.ProductRestClient;
import com.amssolutions.similarproducts.openapi.model.ProductDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class ProductRestClientImpl {

	@Autowired
	private Retrofit retrofit;

	public List<String> getSimilarIds(String productId) {
		
		ProductRestClient client = retrofit.create(ProductRestClient.class);

		List<String> result = new ArrayList<>();
		client.getSimilarIds(productId).enqueue(new Callback<List<String>>() {

			@Override
			public void onResponse(Call<List<String>> call, Response<List<String>> response) {

				result.addAll(response.body());
			}

			@Override
			public void onFailure(Call<List<String>> call, Throwable t) {

			}
		});
		return result;

	}

	public ProductDetail getProduct(String productId) {

		ProductRestClient client = retrofit.create(ProductRestClient.class);
		
		try {
			return client.getProduct(productId).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
