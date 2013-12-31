package com.lister.product.service;

import com.lister.product.model.ProductVariant;

import java.util.List;


public interface ProductVariantService {
	
	
	public void addProductVariant(ProductVariant product);

	public List<ProductVariant> listProduct();

	public void removeProductVariant(Integer id);

	public ProductVariant getProduct(Integer id);

	public List<ProductVariant> searchProduct(String Name);

}
