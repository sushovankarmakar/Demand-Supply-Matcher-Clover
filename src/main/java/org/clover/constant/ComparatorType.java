package org.clover.constant;

import lombok.Getter;

@Getter
public enum ComparatorType {

    BY_DATE_IN_ASCENDING_ORDER("byDateInAscendingOrder"),
    BY_DEMAND_PRICE_IN_DESCENDING_ORDER("byDemandPriceInDescendingOrder"),
    BY_SUPPLY_PRICE_IN_ASCENDING_ORDER("bySupplyPriceInAscendingOrder");

    private final String name;

    ComparatorType(String name) {
        this.name = name;
    }
}
