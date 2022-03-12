package be.intec.dao;

import be.intec.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductRepository {
    public Product getProductByIdFromDB(int id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        return em.find(Product.class, id);
    }

    public List<Product> getProductsForOrderID(int id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Query queryFindOrdersWithOrderID = em.createQuery("SELECT p FROM Product p WHERE p.orderId = :orderIdValue");
        return queryFindOrdersWithOrderID.setParameter("orderIdValue", id).getResultList();
    }

    public void SaveNewProductsToDB(Product productFromNewOrder) {
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.persist(productFromNewOrder);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
