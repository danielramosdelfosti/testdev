package com.amssolutions.similarproducts.controller.client;

import java.util.List;

import com.amssolutions.similarproducts.openapi.model.ProductDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductRestClient {

	@GET("/product/{productId}/similarids")
	public Call<List<String>> getSimilarIds(@Path("productId") String productId);

	@GET("/product/{productId}")
	public Call<ProductDetail> getProduct(@Path("productId") String productId);
}
