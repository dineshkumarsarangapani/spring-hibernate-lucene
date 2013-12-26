package com.lister.product.repository;

import com.lister.product.model.Product;

import java.util.List;

public interface ProductRepository {
    public void addProduct(Product Product);
    public List<Product> listProduct();
    public void removeProduct(Integer id);
}
