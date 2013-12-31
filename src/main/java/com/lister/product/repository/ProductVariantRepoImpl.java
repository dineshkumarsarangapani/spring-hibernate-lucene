package com.lister.product.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lister.product.model.Product;
import com.lister.product.model.ProductVariant;

@Repository
@Transactional
public class ProductVariantRepoImpl implements ProductVariantRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(ProductVariant product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@Override
	public List<ProductVariant> listProduct() {
		Session session = sessionFactory.openSession();
        List<ProductVariant> returnprodlist = session.createQuery("from ProductVariant").list();
        session.close();
		return	returnprodlist;	
	}

	@Override
	public void removeProduct(Integer id) {
		ProductVariant product = (ProductVariant) sessionFactory.openSession().load(
				ProductVariant.class, id);
		if (null != product) {
			sessionFactory.getCurrentSession().delete(product);
		}
		
	}

	@Override
	public ProductVariant getProduct(Integer id) {
		ProductVariant product = (ProductVariant) sessionFactory.openSession().load(
				ProductVariant.class, id);
		// detaching the  product from session, to avoid lazy initialize problem
		//sessionFactory.getCurrentSession().evict(product); 
		return ProductVariant.getProductVariant(product);
	}

}
