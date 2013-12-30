package org.lister.product.indexTest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.lucene.queryParser.ParseException;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lister.product.model.Product;


public class IndexAndSearchTest {

	private static EntityManagerFactory emf;

	private static EntityManager em;

	private static Logger log = LoggerFactory.getLogger( IndexAndSearchTest.class );

	@Before
	public void setUp() {
		try {
			initHibernate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testIndexAndSearch() throws Exception {
		
		Product product = new Product();
		product.setName("Sandy");
		product.setDescription("Sandy Descirption");
		product.setCurrency("USD");
		saveBook(product);
		index();
		List<Product> products= null;
		// search encrypted author
		products = search( );
		assertEquals( "Should find one product", 3, products.size() );		
	}

	private void initHibernate() throws ClassNotFoundException {
		System.out.println("Dinesh ");
		System.out.println(getClass().getResource("META-INF/persistence.xml"));
		System.out.println(Class.forName("org.hibernate.ejb.HibernatePersistence"));
		Map<String, String> config = new HashMap<String, String>();
		config.put("hibernate.connection.url", "jdbc:postgresql://localhost/gam");
		config.put("hibernate.connection.username", "postgres");
		config.put("hibernate.connection.password", "dinesh@123");
		config.put("hibernate.connection.driver_class", "org.postgresql.Driver");
		config.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		config.put("hibernate.show_sql", "true");
		emf = Persistence.createEntityManagerFactory("acme", config);
		em = emf.createEntityManager();
		
	}

	private void index() {
		FullTextSession ftSession = org.hibernate.search.Search.getFullTextSession( (Session) em.getDelegate() );
		try {
			ftSession.createIndexer().startAndWait();
		}
		catch ( InterruptedException e ) {
			log.error( "Was interrupted during indexing", e );
		}
	}

	
	private List<Product> search( ) throws ParseException {

		FullTextEntityManager fullTextEntityManager =  org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
		
		em.getTransaction().begin();
		
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity( Product.class ).get();
		org.apache.lucene.search.Query query = qb.keyword().onField("title").matching("Sandy").createQuery();

		javax.persistence.Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Product.class);

		List<Product> products = persistenceQuery.getResultList();

		em.getTransaction().commit();
		em.close();

		for ( Product b : products ) {
			log.info( "Title: " + b.getName() );
		}
		return products;
		
	}


	private void saveBook(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("acme");
	}

}
