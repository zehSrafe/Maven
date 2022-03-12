package be.intec.view;

import be.intec.model.Product;
import be.intec.service.OrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        List<Product> products = new ArrayList<>();

//        Product product1 = new Product().setProductName("Clipper").setAmount(2).setPricePerUnit(BigDecimal.valueOf(2.99));
//        Product product2 = new Product().setProductName("Keyboard").setAmount(500).setPricePerUnit(BigDecimal.valueOf(144));
//        products.add(product1);
//        products.add(product2);
//        orderService.saveNewOrder("First order with new system", products);
//
//        products.removeAll(products);
//        Product product3 = new Product().setProductName("Cables").setAmount(351).setPricePerUnit(BigDecimal.valueOf(55.5));
//        Product product4 = new Product().setProductName("Water").setAmount(1).setPricePerUnit(BigDecimal.valueOf(99999.99));
//        Product product5 = new Product().setProductName("Beer").setAmount(12357).setPricePerUnit(BigDecimal.valueOf(0.99));
//        products.add(product3);
//        products.add(product4);
//        products.add(product5);
//        orderService.saveNewOrder("Daniel", products);
//
//        products.removeAll(products);
//        products.add(product4);
//        orderService.saveNewOrder("Jaques", products);
        orderService.getAllOrders();
    }
}
