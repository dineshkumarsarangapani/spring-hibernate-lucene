package com.lister.product.service;

import com.lister.product.model.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);
        public List<Product> listProduct();
        public void removeProduct(Integer id);
		public Product getProduct(Integer id);
}
