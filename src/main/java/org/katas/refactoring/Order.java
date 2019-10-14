package org.katas.refactoring;

import java.util.List;

public class Order {
    private String name;
    private String address;
    private List<LineItem> listItems;

    public Order(String name, String address, List<LineItem> listItems) {
        this.name = name;
        this.address = address;
        this.listItems = listItems;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return listItems;
    }
}
