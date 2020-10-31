package org.clover.comparator;

import org.clover.dto.Order;

import java.util.Comparator;

public class CompareByDateInAscendingOrder implements Comparator<Order> {

    @Override
    public int compare(Order order1, Order order2) {
        return order1.getTime().compareTo(order2.getTime());
    }
}
