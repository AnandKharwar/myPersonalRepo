
package com.simplilearn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.dao.ProductDao;
import com.simplilearn.demo.entity.Products;



@Service
public class ProductService {
	
	@Autowired
	private ProductDao repo;
	
	
	//add
	public Products addProducts(Products p) {
		return repo.save(p);
	}
	
	
	//get
	public List<Products> getAllProducts(){
		return repo.findAll();
	}
	
	//get by id
	public Products getProductById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
		
		
	}
	
	
	//update
	
	public Products updateProduct(int id, Products newProduct) {
		if(repo.findById(id).isPresent()) {
			Products oldProduct= repo.findById(id).get();
			oldProduct.setName(newProduct.getName());
			oldProduct.setBrand(newProduct.getBrand());
			oldProduct.setPrice(newProduct.getPrice());
			oldProduct.setQuantity(newProduct.getQuantity());
			oldProduct.setImgurl(newProduct.getImgurl());
			oldProduct.setStatus(newProduct.isStatus());
			
			return repo.save(oldProduct);
		    }
		else {
			return null;
		
	         }
		}
	
	
	//delete
	public boolean deleteProduct(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	

}