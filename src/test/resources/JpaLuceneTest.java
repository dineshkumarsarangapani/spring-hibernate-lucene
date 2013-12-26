
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.mastertheboss.domain.Employee;
import com.mastertheboss.domain.Department;

public class JpaLuceneTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("acme");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        test.listEmployees(manager);

        System.out.println(".. done");
    }

    private void createProduct() {
        int numOfProducts = manager
                .createQuery("Select a From Product a", Product.class)
                .getResultList().size();
        if (numOfProducts == 0) {
            manager.persist(new Employee("Jakab Gipsz", department));
            manager.persist(new Employee("Captain Nemo", department));

        }
    }

    private void listEmployees(EntityManager em) {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
                .getFullTextEntityManager(em);

        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        em.getTransaction().begin();

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Employee.class).get();
        org.apache.lucene.search.Query query = qb.keyword().onFields("name")
                .matching("Captain").createQuery();

        // wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query persistenceQuery = fullTextEntityManager
                .createFullTextQuery(query, Employee.class);

        // execute search
        List<Employee> result = persistenceQuery.getResultList();
        System.out.println("num of employess:" + result);
        for (Employee next : result) {
            System.out.println("next employee: " + next);
        }
        em.getTransaction().commit();
        em.close();

    }

}
