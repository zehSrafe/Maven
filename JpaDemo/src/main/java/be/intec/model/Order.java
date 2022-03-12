package be.intec.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Orders")   // will use this table for orders class. usefull for creating tables of reserved keywords
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // makes Id autoincrement
    private int id;
    private String orderNumber;
    private String orderClient;
    private String orderAddress;
    private int orderPostalCode;
    private String orderCity;
    private boolean vatFree;
    private boolean send;
    private String orderDate;

    // rank is a SQL reserved keyword and thus will fail when trying to create column named "rank"
    // @Column(name = "the name") will set the name you wish as the name of the column
//    @Column(name = "rank_column")
//    private int rank;

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Order setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public String getOrderClient() {
        return orderClient;
    }

    public Order setOrderClient(String orderClient) {
        this.orderClient = orderClient;
        return this;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public Order setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
        return this;
    }

    public int getOrderPostalCode() {
        return orderPostalCode;
    }

    public Order setOrderPostalCode(int orderPostalCode) {
        this.orderPostalCode = orderPostalCode;
        return this;
    }

    public String getOrderCity() {
        return orderCity;
    }

    public Order setOrderCity(String orderCity) {
        this.orderCity = orderCity;
        return this;
    }

    public boolean isVatFree() {
        return vatFree;
    }

    public Order setVatFree(boolean vatFree) {
        this.vatFree = vatFree;
        return this;
    }

    public boolean isSend() {
        return send;
    }

    public Order setSend(boolean send) {
        this.send = send;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public Order setProducts(List<Product> products) {
//        this.products = products;
//        return this;
//    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderClient='" + orderClient + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderPostalCode=" + orderPostalCode +
                ", orderCity='" + orderCity + '\'' +
                ", vatFree=" + vatFree +
                ", send=" + send +
                ", orderDate=" + orderDate +
                '}';
    }
}
