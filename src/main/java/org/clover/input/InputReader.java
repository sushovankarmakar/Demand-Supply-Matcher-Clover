package org.clover.input;

import org.clover.dto.Order;

import java.util.List;

public interface InputReader {

    List<Order> read(String filename);

}
