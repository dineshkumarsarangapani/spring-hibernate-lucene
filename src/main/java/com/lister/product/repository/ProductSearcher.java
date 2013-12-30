package com.lister.product.repository;

import java.util.List;

import com.lister.product.model.Product;

public interface ProductSearcher {
  public Product getProductByName(String name);
  public List<Product> searchProduct(String name);
}
