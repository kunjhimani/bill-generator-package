package com.example.billgeneratorproject.mapper;

import org.springframework.stereotype.Component;

import com.example.billgeneratorproject.dto.CategoryDto;
import com.example.billgeneratorproject.dto.ProductDto;
import com.example.billgeneratorproject.entity.Category;
import com.example.billgeneratorproject.entity.Product;

@Component
public class ProductMapper {

	/* convert ProjectEntity to ProjectDTO */
	public ProductDto mapEntitytoProjectDto(Product product) {
		Category category = product.getCategory();

		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setCategory(mapEntitytoCategoryDto(category));
		return productDto;

	}

	/* Convert CategoryEntity to CategortDto */
	public CategoryDto mapEntitytoCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setCategoryName(category.getCategoryName());
		categoryDto.setLevy(category.getLevy());
		return categoryDto;

	}

}
