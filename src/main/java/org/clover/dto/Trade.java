package org.clover.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Trade {

    private String demandOrderId;
    private String supplyOrderId;
    private Double pricePerKg;
    private Double quantityProvidedInKg;

}
