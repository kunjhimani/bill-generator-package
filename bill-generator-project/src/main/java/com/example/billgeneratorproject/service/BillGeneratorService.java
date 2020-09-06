package com.example.billgeneratorproject.service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.example.billgeneratorproject.dto.ProductDto;
import com.example.billgeneratorproject.entity.Product;

public interface BillGeneratorService {
	
	public boolean addProduct(String productName);
	
	public HashMap<ProductDto, Integer> generateTotalBill();
	
	public List<String> getProductsName();
	
	public int getTotal(String key);
	
	

}
