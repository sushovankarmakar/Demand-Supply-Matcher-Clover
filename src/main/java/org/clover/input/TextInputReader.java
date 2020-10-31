package org.clover.input;

import lombok.NonNull;
import org.clover.constant.ErrorMessage;
import org.clover.dto.Order;
import org.clover.exception.DateParsingException;
import org.clover.exception.InvalidInputException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.clover.constant.ErrorMessage.DATE_NOT_PARSED;

public class TextInputReader implements InputReader {

    @Override
    public List<Order> read(@NonNull String filename) {

        Objects.requireNonNull(filename, ErrorMessage.FILE_NAME_IS_NULL.getMessage());

        String delimiter = "\\s+";

        List<Order> orders = new ArrayList<>();

        try (BufferedReader objectReader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = objectReader.readLine()) != null) {

                String[] orderDetails = line.split(delimiter);

                if (orderDetails.length != 5) {
                    throw new InvalidInputException(ErrorMessage.INVALID_INPUT_FORMAT);
                }

                String orderId = orderDetails[0];
                Date time = getCurrentDateTime(orderDetails[1]);
                String produce = orderDetails[2];
                Double pricePerKg = Double.parseDouble(orderDetails[3].split("/")[0]);
                Double quantityInKg = Double.parseDouble(orderDetails[4].split("[^0-9]")[0]);

                orders.add(Order.builder()
                        .orderId(orderId)
                        .time(time)
                        .produce(produce)
                        .pricePerKg(pricePerKg)
                        .quantityInKg(quantityInKg)
                        .build());
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return orders;
    }

    private Date getCurrentDateTime(String currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm");

        LocalDate currentDate = LocalDate.now();
        String dateInString = currentDate.toString() + ", " + currentTime;

        Date date;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new DateParsingException(DATE_NOT_PARSED);
        }
        return date;
    }
}
