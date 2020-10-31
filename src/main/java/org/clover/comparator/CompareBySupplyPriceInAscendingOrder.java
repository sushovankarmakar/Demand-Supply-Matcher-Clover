package org.clover.comparator;

import org.clover.dto.Order;

import java.util.Comparator;

public class CompareBySupplyPriceInAscendingOrder implements Comparator<Order> {

    @Override
    public int compare(Order order1, Order order2) {
        return order1.getPricePerKg().compareTo(order2.getPricePerKg());
    }
}
