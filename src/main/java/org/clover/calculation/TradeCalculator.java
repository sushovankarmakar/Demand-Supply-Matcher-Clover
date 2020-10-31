package org.clover.calculation;

import lombok.NonNull;
import org.clover.comparator.ComparatorFactory;
import org.clover.constant.ErrorMessage;
import org.clover.dto.Order;
import org.clover.dto.Trade;

import java.util.*;

import static org.clover.constant.ComparatorType.*;
import static org.clover.constant.ErrorMessage.COMPARATOR_NOT_FOUND;

public class TradeCalculator {

    public List<Trade> calculate(@NonNull List<Order> orders) {

        Objects.requireNonNull(orders, ErrorMessage.ORDER_LIST_IS_NULL.getMessage());

        List<Order> demandList = new ArrayList<>();
        List<Order> supplyList = new ArrayList<>();
        List<Trade> trades = new ArrayList<>();

        for (Order order : orders) {
            if (order.getOrderId().substring(0,1).equalsIgnoreCase("d")) {
                demandList.add(order);
            } else {
                supplyList.add(order);
            }
        }

        Comparator<Order> byDateInAscendingOrder =
                Objects.requireNonNull(ComparatorFactory.getComparator(BY_DATE_IN_ASCENDING_ORDER), COMPARATOR_NOT_FOUND.getMessage());
        Comparator<Order> byDemandPriceInDescendingOrder =
                Objects.requireNonNull(ComparatorFactory.getComparator(BY_DEMAND_PRICE_IN_DESCENDING_ORDER), COMPARATOR_NOT_FOUND.getMessage());
        Comparator<Order> bySupplyPriceInAscendingOrder =
                Objects.requireNonNull(ComparatorFactory.getComparator(BY_SUPPLY_PRICE_IN_ASCENDING_ORDER), COMPARATOR_NOT_FOUND.getMessage());


        Collections.sort(demandList, byDateInAscendingOrder.thenComparing(byDemandPriceInDescendingOrder));
        Collections.sort(supplyList, byDateInAscendingOrder.thenComparing(bySupplyPriceInAscendingOrder));

        for (Order demand : demandList) {

            if (demand.getQuantityInKg() > 0.0) {

                List<Order> supplyBeforeDemandComes = new ArrayList<>();
                List<Order> supplyAfterDemandComes = new ArrayList<>();

                for (Order supply : supplyList) {

                    if (supply.getTime().before(demand.getTime()) || supply.getTime().equals(demand.getTime())) {
                        supplyBeforeDemandComes.add(supply);
                    } else {
                        supplyAfterDemandComes.add(supply);
                    }
                }

                Collections.sort(supplyBeforeDemandComes, bySupplyPriceInAscendingOrder.thenComparing(byDateInAscendingOrder));

                demandSupplyMatcher(demand, supplyBeforeDemandComes, trades);
                demandSupplyMatcher(demand, supplyAfterDemandComes, trades);
            }
        }
        return trades;
    }

    private void demandSupplyMatcher(Order demand, List<Order> supplyList, List<Trade> trades) {

        for (Order supply : supplyList) {

            if (supply.getQuantityInKg() > 0.0 &&
                    demand.getProduce().equalsIgnoreCase(supply.getProduce()) &&
                    demand.getPricePerKg() >= supply.getPricePerKg()) {

                Double quantityProvided;

                if (supply.getQuantityInKg() >= demand.getQuantityInKg()) {
                    quantityProvided = demand.getQuantityInKg();
                    supply.setQuantityInKg(supply.getQuantityInKg() - quantityProvided);
                    demand.setQuantityInKg(0.0);
                } else {
                    quantityProvided = supply.getQuantityInKg();
                    supply.setQuantityInKg(0.0);
                    demand.setQuantityInKg(demand.getQuantityInKg() - quantityProvided);
                }

                trades.add(Trade.builder()
                        .demandOrderId(demand.getOrderId())
                        .supplyOrderId(supply.getOrderId())
                        .pricePerKg(supply.getPricePerKg())
                        .quantityProvidedInKg(quantityProvided)
                        .build());
            }
        }
    }
}
