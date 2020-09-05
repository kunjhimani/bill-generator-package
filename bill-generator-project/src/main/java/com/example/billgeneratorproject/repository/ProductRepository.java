package com.example.billgeneratorproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.billgeneratorproject.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>  {
	
	Optional<Product> findByName(String productName);
	
	 @Query(value="select name from product" , nativeQuery=true)
	   List<String> getAllName();
	
}  