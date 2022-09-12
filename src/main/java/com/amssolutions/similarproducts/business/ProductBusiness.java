package com.amssolutions.similarproducts.business;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amssolutions.similarproducts.business.client.ProductRestClientImpl;
import com.amssolutions.similarproducts.openapi.model.ProductDetail;

@Service
public class ProductBusiness {

	@Autowired
	private ProductRestClientImpl productRestClientImpl;

	public Set<ProductDetail> getProductSimilar(String productId) {

		return productRestClientImpl.getSimilarIds(productId).stream().map(id -> productRestClientImpl.getProduct(id))
				.collect(Collectors.toSet());

	}

}
