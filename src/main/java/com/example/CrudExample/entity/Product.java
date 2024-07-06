package com.example.CrudExample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "PRODUCT_TABL")
public class Product {

	  @Id
	    //@GeneratedValue(strategy=GenerationType.AUTO)
	    private int id;
	    private String name;
	    private int quantity;
	    private double price;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Product(int id, String name, int quantity, double price) {
			super();
			this.id = id;
			this.name = name;
			this.quantity = quantity;
			this.price = price;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
		}
	    
	    
}
