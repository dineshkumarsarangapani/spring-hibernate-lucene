package com.lister.product.search;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lister.product.model.Product;

@Component
public class ProductSearcherImpl implements ProductSearcher {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product getProductByName(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		
		QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
		org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("name").matching(name).createQuery();

		org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Product.class);
		
		List<Product> ProductList = fullTextQuery.list();
		
		fullTextSession.close();
		
		return (Product) ProductList;
	}

	@Override
	public List<Product> searchProduct(String name) {
		
		Session session = sessionFactory.openSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		Transaction tx = fullTextSession.beginTransaction();
		
		QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
		org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("name", "description").matching(name).createQuery();

		org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Product.class);
		
		List<Product> ProductList = fullTextQuery.list();
		
		tx.commit();
		fullTextSession.close();

		return ProductList;
	}

}
