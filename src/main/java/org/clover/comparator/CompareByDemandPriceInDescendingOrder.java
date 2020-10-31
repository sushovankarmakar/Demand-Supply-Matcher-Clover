package org.clover.comparator;

import org.clover.dto.Order;

import java.util.Comparator;

public class CompareByDemandPriceInDescendingOrder implements Comparator<Order> {

    @Override
    public int compare(Order order1, Order order2) {
        return order2.getPricePerKg().compareTo(order1.getPricePerKg());
    }
}
