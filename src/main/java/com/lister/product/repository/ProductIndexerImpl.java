package com.lister.product.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lister.product.model.Product;

@Repository
@Transactional
public class ProductIndexerImpl implements ProductIndexer {
	
	
	private EntityManagerFactory entitymanagerfactory;
	
	public EntityManagerFactory getEntitymanagerfactory() {
		return entitymanagerfactory;
	}

	@PersistenceUnit
	public void setEntitymanagerfactory(EntityManagerFactory entitymanagerfactory) {
		this.entitymanagerfactory = entitymanagerfactory;
	}

	public void addProduct(Product Product) {
		EntityManager manager = this.entitymanagerfactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(Product);
		tx.commit();
	}
}
