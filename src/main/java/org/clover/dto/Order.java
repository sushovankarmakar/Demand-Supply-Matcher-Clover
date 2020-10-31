package org.clover.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Order {

    private String orderId;
    private Date time;
    private String produce;
    private Double pricePerKg;
    private Double quantityInKg;

}
