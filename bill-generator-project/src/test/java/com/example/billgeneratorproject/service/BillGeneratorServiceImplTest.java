package com.example.billgeneratorproject.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.billgeneratorproject.dto.CategoryDto;
import com.example.billgeneratorproject.dto.ProductDto;
import com.example.billgeneratorproject.mapper.ProductMapper;
import com.example.billgeneratorproject.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
class BillGeneratorServiceImplTest {

	static Logger logger = Logger.getLogger(BillGeneratorServiceImplTest.class.getName());

	@Mock
	ProductRepository productRepositoryMock;

	@Mock
	private ProductMapper productMapperMock;

	BillGeneratorServiceImpl billGeneratorService = new BillGeneratorServiceImpl();

	@BeforeClass
	public static void beforeClass() {
		logger.info("Unit testing for BillGeneratorServiceImplTest has started");
	}

	@AfterClass
	public static void afterClass() {
		logger.info("Unit testing for BillGeneratorServiceImplTest has finished");
	}

	/* test if total price is calculated correctly */
	@Test
	public void totalPriceOfAnItem() {
		BillGeneratorServiceImpl.productDetailsList.put(new ProductDto(1200, "samsung", new CategoryDto("A", 10)), 2);
		assertNotNull(BillGeneratorServiceImpl.productDetailsList);
		assertEquals(2400, billGeneratorService.getTotal("price"));
	}

	/* test if total tax is calculated correctly */
	@Test
	public void totalTaxOfAnItem() {
		BillGeneratorServiceImpl.productDetailsList.put(new ProductDto(1200, "samsung", new CategoryDto("A", 10)), 2);
		assertEquals(240, billGeneratorService.getTotal("tax"));
	}

	@Test
	public void addProduct() {
		assertTrue(billGeneratorService.addProduct("samsung") == true);
	}

	/* test if products name are fetched calculated correctly */
	@Test
	public void getProductsName() {
		assertEquals(Arrays.asList("samsung", "iphone", "orange", "apple", "pencil", "pen"),
				billGeneratorService.getProductsName());
	}

	@Test
	public void isCorrectProductFetchedByName() {
		assertEquals("samsung",
				productMapperMock.mapEntitytoProjectDto(productRepositoryMock.findByName("samsung").get()).getName());
	}

	@Test
    public void addProductIfSameProductAddedTwice() {
		//adding apple twice
		billGeneratorService.addProduct("apple");
		billGeneratorService.addProduct("apple");
		//checking value of hashMap with key as apple
		assertEquals(2,BillGeneratorServiceImpl.productDetailsList.get(productMapperMock.mapEntitytoProjectDto(
				productRepositoryMock.findByName("samsung").get()).getName()));
    	
    }
	
	
	//test if correct category is fetched
	@Test
	public void isCorrectCategoryFetched() {
		assertEquals("A",productRepositoryMock.findByName("samsung").get().getCategory().getCategoryName());
	}

}
