package com.example.billgeneratorproject.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.example.billgeneratorproject.dto.CategoryDto;
import com.example.billgeneratorproject.dto.ProductDto;
import com.example.billgeneratorproject.repository.ProductRepository;
import com.example.billgeneratorproject.service.BillGeneratorService;
import com.example.billgeneratorproject.service.BillGeneratorServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class BillGeneratorControllerTest {
	
	@Mock
	BillGeneratorService billGeneratorService;
	
	@Mock
	BillGeneratorServiceImpl billGeneratorServiceImplMock;
	

	static Logger logger = Logger.getLogger(BillGeneratorControllerTest.class.getName());
	BillGeneratorController billGeneratorController = new BillGeneratorController();


	@BeforeClass
	public static void beforeClass() {
		
		logger.info("Unit testing for BillGeneratorController has started");
	}

	@AfterClass
	public static void afterClass() {
		logger.info("Unit testing for BillGeneratorController has finished");
	}
	
	@Test
    public void areProductsNameFetched() {
    	assertEquals(Arrays.asList("samsung","iphone","orange","apple","pencil","pen") , 
    			billGeneratorService.getProductsName());
    }
	
	@Test
    public void isProductAdded() {
    	assertEquals(true,billGeneratorService.addProduct("apple") );
    }
	

}
