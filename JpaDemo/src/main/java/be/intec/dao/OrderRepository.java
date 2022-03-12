package be.intec.dao;

import be.intec.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class OrderRepository {
    public Order getOrderByIdFromDb(int id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        return em.find(Order.class, id);
    }

    public Order saveNewOrderToDB(Order order) {
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        em.persist(order); // adds an object to EntityManager
        em.getTransaction().commit(); // sends all data to db
        // rollback will rollback to data in state after em.getTransaction().begin();
//        em.getTransaction().rollback();
        return order;
    }

    public void renameOrderWithIdInDB(int id, String newName) {
        EntityManager em = EntityManagerProvider.getEntityManager();

        Order orderToRename = em.find(Order.class, id);
        orderToRename.setOrderClient(newName);
        em.merge(orderToRename);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    public void removeRecordFromDB(int id) {
        EntityManager em = EntityManagerProvider.getEntityManager();

        Order orderToRemoved = em.find(Order.class, id);
        em.remove(orderToRemoved);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    public List<Order> getAllOrdersFromDB() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Query queryAllOrders = em.createQuery("SELECT o FROM Order o", Order.class);
        return queryAllOrders.getResultList();
    }

    public Order getLastOrderNumberFromDB() throws NoResultException {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Query queryOrder = em.createQuery("SELECT o FROM Order o ORDER BY o.id DESC", Order.class).setMaxResults(1);
        return (Order) queryOrder.getSingleResult();
    }
}
