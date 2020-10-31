package org.clover.output;

import org.clover.dto.Trade;

import java.util.List;

public interface OutputPublisher {

    void publish(List<Trade> trades);

}
