package com.example.CrudExample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudExample.entity.Product;
import com.example.CrudExample.service.ProductService;


@RestController
public class ProductController 
{
  @Autowired
  private ProductService service;
  
  //creating logger and use logging
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
  
  @PostMapping("/addProduct")
  public Product addProduct(@RequestBody Product product)
  {
      return service.saveProduct(product);
  }
  @PostMapping("/addProducts")
  public List<Product> addProducts(@RequestBody List<Product> products)
  {
      return service.saveProducts(products);
  }

  @GetMapping("/products")
  public List<Product> findAllProducts()
  {
      return service.getProducts();
  }
  @GetMapping("/productById/{id}")
  public Product findById(@PathVariable int id)
  {
	  //using logger instance to get log
	  LOGGER.info("Finding prod by ID" +id);
      return service.getProductById(id);
  }
  @GetMapping("/product/{name}")
  public Product findByName(@PathVariable String name)
  {
      return service.getProductByName(name);
  }

  @PutMapping("/update")
  public Product updateProduct(@RequestBody Product product)
  {
      return service.updateProduct(product);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteProduct(@PathVariable int id)
  {
      return service.deleteProduct(id);
  }

}
