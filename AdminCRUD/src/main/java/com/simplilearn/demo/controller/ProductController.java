package com.simplilearn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.demo.entity.Products;
import com.simplilearn.demo.service.ProductService;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/user")
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/")
	public ResponseEntity<Products> adduser(@RequestBody Products p){
		
		Products Products= service.addProducts(p);
		
		if(Products!=null)
			return new ResponseEntity<Products>(Products,HttpStatus.CREATED);
		else
			return new ResponseEntity<Products>(Products,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@GetMapping("/")
	public List<Products> getAllUser(){
		return service.getAllProducts();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Products>getUserById (@PathVariable int id){
		Products Product= service.getProductById(id);
		
		if(Product!=null)
			return new ResponseEntity<Products>(Product, HttpStatus.FOUND);
		else
			return new ResponseEntity<Products>(Product, HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable int id,@RequestBody Products newProduct){
		Products Product= service.updateProduct(id, newProduct);
		
		if (Product!=null)
			return new ResponseEntity<Object>(Product,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No User Available to Update",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable int id){
		boolean result = service.deleteProduct(id);
		if(result) 
			return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<String>("NO user Found", HttpStatus.NOT_FOUND);
		
	}
 
}