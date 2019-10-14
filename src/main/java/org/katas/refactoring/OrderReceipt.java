package org.katas.refactoring;

import java.util.HashMap;
import java.util.Map;

public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
    }
    private Map<String, Double> getLineItemReceipt(Order o) {
        StringBuilder output = new StringBuilder();
        Map<String, Double> getLineItemReceipt = new HashMap<>();
        double TotalSalesWithTax = 0d;
        double TotalSales = 0d;
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            TotalSalesWithTax += calculateSalesTax(lineItem);
            TotalSales += lineItem.totalAmount() + calculateSalesTax(lineItem);
        }
        getLineItemReceipt.put("TotalSalesWithTax", TotalSalesWithTax);
        getLineItemReceipt.put("TotalSales", TotalSales);
        return getLineItemReceipt;
    }
    public String printReceipt() {
        Map<String, Double> getLineItemReceipt = getLineItemReceipt(o);
        StringBuilder output = new StringBuilder();
        output.append("======Printing Orders======\n");
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
        output.append("Sales Tax").append('\t').append(getLineItemReceipt.get("TotalSalesWithTax"));
        output.append("Total Amount").append('\t').append(getLineItemReceipt.get("TotalSales"));
        return output.toString();
    }
    private double calculateSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }
}