package be.intec.service;

import be.intec.dao.OrderRepository;
import be.intec.dao.ProductRepository;
import be.intec.model.Order;
import be.intec.model.Product;

import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private ProductRepository productRepository = new ProductRepository();

    public void getOrderById(int id) {
        Order order = orderRepository.getOrderByIdFromDb(id);
        if (order == null) {
            System.out.println("Order with id " + id + " could not be found.");
        } else {
            System.out.println("Order:");
            System.out.println(order);
            System.out.println("With products:");
            List<Product> orderedProducts = productRepository.getProductsForOrderID(order.getId());
            orderedProducts.forEach(System.out::println);
        }
    }

    private int getLastOrderNumber() {
        try {
            String fullOrderNumber = orderRepository.getLastOrderNumberFromDB().getOrderNumber();
            String extractedNumber = fullOrderNumber.substring(fullOrderNumber.lastIndexOf('-') + 1);
            return Integer.parseInt(extractedNumber);
        } catch (NoResultException e) {
            // returns 0 if no results where found. will only happen when creating very first order
            return 0;
        }
    }

    public void saveNewOrder(String clientName, List<Product> productsFromNewOrder) {
        Date todaysDate = new Date();
        SimpleDateFormat todaysFormatter = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat todaysFormatterForDB = new SimpleDateFormat("yyyy-MM-dd");
        String todaysFormattedDate = todaysFormatter.format(todaysDate);
        int orderNumber = getLastOrderNumber() + 1;
        String newOrderNumber = "ORD-" + todaysFormattedDate + "-" + orderNumber;

        Order order = new Order().setOrderClient(clientName).setOrderCity("Bruxelles").setOrderAddress("Street name")
                .setOrderNumber(newOrderNumber).setOrderPostalCode(1000).setSend(false).setVatFree(false)
                .setOrderDate(todaysFormatterForDB.format(todaysDate));
        orderRepository.saveNewOrderToDB(order);

        int createdOrderID = orderRepository.getLastOrderNumberFromDB().getId();

        for (Product product : productsFromNewOrder) {
            product.setOrderId(createdOrderID);
            productRepository.SaveNewProductsToDB(product);
        }
        getOrderById(createdOrderID);
    }

    public void renameOrderWithId(int id, String newName) {
        System.out.println("Renamed order:");
        getOrderById(id);

        orderRepository.renameOrderWithIdInDB(id, newName);

        System.out.println("To:");
        getOrderById(id);
    }

    public void removeRecordWithID(int id) {
        try {
            orderRepository.removeRecordFromDB(id);
            System.out.println("Successfully removed order with id " + id + "!");
        } catch (Exception e) {
            System.out.println("Record with id " + id + " could not be found. Delete attempt failed!");
        } finally {
            System.out.println("Remaining orders in database:");
            getAllOrders();
        }
    }

    public void getAllOrders() {
        List<Order> orders = orderRepository.getAllOrdersFromDB();
        for (Order order : orders) {
            getOrderById(order.getId());
        }
    }
}
