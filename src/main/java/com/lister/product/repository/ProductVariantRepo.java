package com.lister.product.repository;

import java.util.List;

import com.lister.product.model.ProductVariant;

public interface ProductVariantRepo {
	 public void addProduct(ProductVariant product);
	    public List<ProductVariant> listProduct();
	    public void removeProduct(Integer id);
	    public ProductVariant getProduct(Integer id);
}
