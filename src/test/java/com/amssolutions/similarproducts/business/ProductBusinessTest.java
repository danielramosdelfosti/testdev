package com.amssolutions.similarproducts.business;



import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.amssolutions.similarproducts.business.client.ProductRestClientImpl;
import com.amssolutions.similarproducts.openapi.model.ProductDetail;

@RunWith(SpringRunner.class)
public class ProductBusinessTest {

	@TestConfiguration
    static class ProductBusinessTestContextConfiguration {
 
        @Bean
        public ProductBusiness productBusiness() {
            return new ProductBusiness();
        }
    }
	
	@Autowired
    public ProductBusiness productBusiness;
	
	@MockBean
	private ProductRestClientImpl productRestClientImpl;

	@Before
	public void setUp() throws IOException {

		ProductDetail detail = new ProductDetail();
		detail.setAvailability(true);
		detail.setId("1");

		Mockito.when(productRestClientImpl.getProduct(Mockito.anyString())).thenReturn(detail);

		Mockito.when(productRestClientImpl.getSimilarIds(Mockito.anyString())).thenReturn(Arrays.asList("1", "2"));

	}
	

}
