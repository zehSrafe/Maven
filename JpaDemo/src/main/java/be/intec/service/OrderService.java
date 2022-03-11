package be.intec.service;

import be.intec.dao.OrderRepository;
import be.intec.model.Order;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    public void getOrderById(int id) {
        Order order = orderRepository.getOrderByIdFromDb(id);
        if (order == null) {
            System.out.println("Order with id " + id + " could not be found.");
        } else {
            System.out.println(order);
        }
    }

    public void saveNewOrder(String clientName) {
        Order order = new Order().setOrderClient(clientName).setOrderCity("Bruxelles").setOrderAddress("Street name")
                .setOrderNumber("ORD-202211-0022").setOrderPostalCode(1000).setSend(false).setVatFree(false);
        orderRepository.saveNewOrderToDB(order);
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
        }
    }
}
