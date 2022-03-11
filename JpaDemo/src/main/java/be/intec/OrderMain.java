package be.intec;

import be.intec.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderMain {
    // create emf using name declared in resources/META-INF/persistance.xml
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
//        writeToDb("JPA_client_number_two");
//        removeRecordFromDB(2);
        renameRecordFromDB(3, "renamed");
        readRecordFromDB(3);
    }

    private static void readRecordFromDB(int id) {
        Order orderFromDB = em.find(Order.class, id);
        System.out.println(orderFromDB.toString());
    }

    private static void writeToDb(String clientName) {
        Order order = new Order();
        order.setOrderClient(clientName).setOrderCity("Bruxelles").setOrderAddress("Street name")
                .setOrderNumber("ORD-202211-0022").setOrderPostalCode(1000).setSend(false).setVatFree(false);

        //<property name="hibernate.hbm2ddl.auto" value="update"/> in XML will make it so it creates table if non existant
        em.persist(order);
        executeChanges();
    }

    private static void renameRecordFromDB(int id, String newName) {
        Order orderToRename = em.find(Order.class, id);

        orderToRename.setOrderClient(newName);
        em.merge(orderToRename);
        executeChanges();
    }

    private static void removeRecordFromDB(int id) {
        Order orderToRemoved = em.find(Order.class, id);

        em.remove(orderToRemoved);
        executeChanges();
    }

    private static void executeChanges() {
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
