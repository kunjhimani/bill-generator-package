package com.example.billgeneratorproject.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billgeneratorproject.dto.ProductDto;
import com.example.billgeneratorproject.entity.Product;
import com.example.billgeneratorproject.service.BillGeneratorService;

@Controller
@RequestMapping("/billGenerator")
public class BillGeneratorController {
	
	static Logger logger = Logger.getLogger(BillGeneratorController.class.getName());

	@Autowired
	private BillGeneratorService billGeneratorService;

	/*
	 *  homepage
	 */
	@GetMapping("/home")
	public String homePage(Model model) {
		
		logger.info("add items to your cart here");
		model.addAttribute("products", billGeneratorService.getProductsName());
		model.addAttribute("productDetailsList", billGeneratorService.generateTotalBill());
		return "home";
	}

	/* 
	 * add product to your shopping list 
	 * */
	@PostMapping("/addProduct")
	public String addProduct(@Valid String productName) {
		billGeneratorService.addProduct(productName);
		return "redirect:/billGenerator/home";
	}

	/* 
	 * generate your total bill 
	 * */
	@GetMapping("/generateBill")
	public String generateBill(Model model) {
		
		logger.info("generate your total bill here");
		/* get total price of items without tax */
		model.addAttribute("totalPrice", billGeneratorService.getTotal("price"));
		
		/* get total tax on items */
		model.addAttribute("totalTax", billGeneratorService.getTotal("tax"));
		
		/* return the list of all items */
		model.addAttribute("productDetailsList", billGeneratorService.generateTotalBill());
		return "total-bill";
	}

}
