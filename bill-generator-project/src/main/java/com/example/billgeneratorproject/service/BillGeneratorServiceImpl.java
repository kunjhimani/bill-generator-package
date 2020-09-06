package com.example.billgeneratorproject.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.billgeneratorproject.dto.ProductDto;
import com.example.billgeneratorproject.entity.Product;
import com.example.billgeneratorproject.enums.CONSTANTS;
import com.example.billgeneratorproject.mapper.ProductMapper;
import com.example.billgeneratorproject.repository.ProductRepository;

@Component
public class BillGeneratorServiceImpl implements BillGeneratorService {

	public static HashMap<ProductDto, Integer> productDetailsList = new HashMap<ProductDto, Integer>();

	@Autowired
	ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	public boolean addProduct(String productName) {

		/* fetch product details from product name */
		ProductDto addProduct = productMapper.mapEntitytoProjectDto(productRepository.findByName(productName).get());

		if (productDetailsList.containsKey(addProduct)) {
			/* if product already exists in the list */
			productDetailsList.put(addProduct,new Integer(productDetailsList.get(addProduct) + CONSTANTS.ONE.getValue()));
			return false;
		} else {
			/* if new product is added */
			productDetailsList.put(addProduct, new Integer(CONSTANTS.ONE.getValue()));
			return true;
		}

	}

	public List<String> getProductsName() {
		return productRepository.getAllName();

	}

	public HashMap<ProductDto, Integer> generateTotalBill() {
		return productDetailsList;
	}

	public int getTotal(String key) {
		int total = 0;
		for (Map.Entry<ProductDto, Integer> entry : productDetailsList.entrySet()) {
			if (key.equalsIgnoreCase("price")) {
				total = total + (entry.getKey().getPrice()*entry.getValue());
			} else if (key.equalsIgnoreCase("tax")) {
				total = total + ((entry.getValue() * entry.getKey().getCategory().getLevy()*entry.getKey().getPrice())/100);
			}
		}
		return total;

	}

}
