package com.example.CrudExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudExample.entity.Product;
import com.example.CrudExample.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
    private ProductRepository repository;

    //postmethod
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    //getmethod
    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByname(name);
    }

    //deletemethod
    public String deleteProduct(int id)
    {
        repository.deleteById(id);
        return "Removed Product!!" +id;
    }

    //Updatemethod
    public Product updateProduct(Product product)
    {
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

}



