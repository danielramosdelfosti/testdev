package com.amssolutions.similarproducts.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.amssolutions.similarproducts.business.ProductBusiness;
import com.amssolutions.similarproducts.openapi.api.ProductApi;
import com.amssolutions.similarproducts.openapi.model.ProductDetail;

@RestController
public class ProductController implements ProductApi {

	@Autowired
	private ProductBusiness productBusiness;
	
	@Override
	public ResponseEntity<Set<ProductDetail>> getProductSimilar(String productId) {

		return ResponseEntity.ok(productBusiness.getProductSimilar(productId));

	}

}
