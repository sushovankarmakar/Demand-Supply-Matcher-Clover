package org.clover.comparator;

import org.clover.constant.ComparatorType;

import java.util.Comparator;

public class ComparatorFactory {

    public static Comparator getComparator(ComparatorType compareBy) {

        switch (compareBy) {
            case BY_DATE_IN_ASCENDING_ORDER :
                return new CompareByDateInAscendingOrder();
            case BY_DEMAND_PRICE_IN_DESCENDING_ORDER :
                return new CompareByDemandPriceInDescendingOrder();
            case BY_SUPPLY_PRICE_IN_ASCENDING_ORDER :
                return new CompareBySupplyPriceInAscendingOrder();
            default: return null;
        }
    }
}
