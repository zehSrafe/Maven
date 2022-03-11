package be.intec.view;

import be.intec.service.OrderService;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.getOrderById(1);
//        orderService.saveNewOrder("order made with layerd layout");
//        orderService.renameOrderWithId(3, "Renamed with layering");
//        orderService.removeRecordWithID(3);
    }
}
