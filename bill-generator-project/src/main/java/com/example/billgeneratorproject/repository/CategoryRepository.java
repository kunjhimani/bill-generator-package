package com.example.billgeneratorproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.billgeneratorproject.entity.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Product, Integer> {
	
	

}
