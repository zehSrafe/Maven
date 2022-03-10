package be.intec;

import be.intec.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
//        writeToDb("Hello database", 1);
        readFromDb(1);
    }

    private static void writeToDb(String messageToWrite, int id) {
        // create emf using name declared in resources/META-INF/persistance.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();

        Message message = new Message();
        message.setId(id);
        message.setMessage(messageToWrite);

        //<property name="hibernate.hbm2ddl.auto" value="update"/> in XML will make it so it creates table if non existant
        em.persist(message);

        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    private static void readFromDb(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();

        Message message = em.find(Message.class, id);
        System.out.println(message);
    }
}
