package org.clover;

import org.clover.calculation.TradeCalculator;
import org.clover.constant.ErrorMessage;
import org.clover.dto.Order;
import org.clover.dto.Trade;
import org.clover.exception.InvalidInputException;
import org.clover.input.InputReader;
import org.clover.input.InputReaderFactory;
import org.clover.output.OutputPublisher;
import org.clover.output.OutputPublisherImpl;

import java.util.*;

import static org.clover.constant.FileType.TEXT;

/**
 * DESCRIPTION :
 * {@code DemandSupplyMatcherMain} class is the main method of this programme.
 *
 * It performs the following things :
 *  1. Takes input from CLI.
 *  2. Uses Input reader to get Input objects.
 *  3. Initialize the orders
 *  4. Declares trade list.
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

public class DemandSupplyMatcherMain {

    public static void main(String[] args) {

        if (Objects.isNull(args) || args.length == 0) {
            throw new InvalidInputException(ErrorMessage.NO_PATH_PROVIDED);
        }

        String fileName = args[0];

        InputReader inputReader = new InputReaderFactory().getInputReader(TEXT);
        List<Order> orders = inputReader.read(fileName);

        TradeCalculator calculator = new TradeCalculator();
        List<Trade> trades = calculator.calculate(orders);

        OutputPublisher publisher = new OutputPublisherImpl();
        publisher.publish(trades);
    }
}
