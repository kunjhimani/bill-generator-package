package com.example.billgeneratorproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.billgeneratorproject.entity.Product;
import com.example.billgeneratorproject.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BillegeneratorTest {

	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ProductRepository productRepository;
    
    
	/*
	 * things to test
	 * controller
	 * - add product returns boolean
	 * - bill is not null
	 * - if value selected is a string
	 * - service if list 
	 * -
	 * 
	 */
    
    @Test
    public void returnsProductWhenfoundByName() {
   
    }

}
