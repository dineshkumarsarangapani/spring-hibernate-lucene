package com.lister.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lister.product.model.Product;
import com.lister.product.model.ProductVariant;
import com.lister.product.repository.ProductVariantRepo;


@Service
public class ProductVariantServImpl implements ProductVariantService{

	@Autowired
	ProductVariantRepo prodvariant;
	
	@Override
	public void addProductVariant(ProductVariant productvariant) {
		 if(productvariant != null){
			 prodvariant.addProduct(productvariant);
	        }
	        else {
	            throw new NullPointerException("Product value can not be done!");
	        }
		
	}

	@Override
	public List<com.lister.product.model.ProductVariant> listProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProductVariant(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public com.lister.product.model.ProductVariant getProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.lister.product.model.ProductVariant> searchProduct(
			String Name) {
		// TODO Auto-generated method stub
		return null;
	}

}
