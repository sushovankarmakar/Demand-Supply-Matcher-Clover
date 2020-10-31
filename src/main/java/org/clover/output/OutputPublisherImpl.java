package org.clover.output;

import org.clover.dto.Trade;

import java.util.List;

public class OutputPublisherImpl implements OutputPublisher {

    @Override
    public void publish(List<Trade> trades) {

        StringBuilder sb = new StringBuilder();

        for (Trade trade : trades) {
            sb.append(trade.getDemandOrderId()).append(" ");
            sb.append(trade.getSupplyOrderId()).append(" ");
            sb.append(trade.getPricePerKg()).append("/kg ");
            sb.append(trade.getQuantityProvidedInKg()).append("kg").append("\n");
        }

        if (sb.length() == 0) {
            System.out.println("NO MATCHING FOUND");
        } else {
            System.out.print(sb);
            sb.setLength(0);
        }
    }
}
