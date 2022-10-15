package com.simplilearn.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.simplilearn.demo.entity.Products;

@Repository
public interface ProductDao extends JpaRepository<Products,Integer> {

}