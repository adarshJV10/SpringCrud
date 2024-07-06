package com.example.CrudExample;

import static org.junit.Assert.*;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.CrudExample.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrudExampleApplicationTests {

	@Value("${productrestapi.service.url}")
	private String baseURL;
	
	@Test
	public void testGetProduct() {
		System.out.println(baseURL);
		RestTemplate restTemplate = new RestTemplate();
		//Product product = restTemplate.getForObject("http://localhost:8080/productById/4", Product.class);
		Product product = restTemplate.getForObject(baseURL+"4", Product.class);
		assertNotNull(product);
		assertEquals("Anchal", product.getName());
	}
	
	@Test
	public void testCreateProduct()
	{
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Anchal");
		product.setPrice(789);
		product.setQuantity(70);
		Product product2 = restTemplate.postForObject("http://localhost:8080/addProduct", product, Product.class);
		assertNotNull(product2);
		assertNotNull(product2.getId());
		assertEquals("Anchal", product2.getName());
	}
}
