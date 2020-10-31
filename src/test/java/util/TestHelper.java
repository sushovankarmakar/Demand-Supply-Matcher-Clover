package util;

import org.clover.dto.Order;
import org.clover.dto.Trade;
import org.clover.exception.DateParsingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.clover.constant.ErrorMessage.DATE_NOT_PARSED;

public class TestHelper {

    public static List<Order> getOrders() {

        Order s1 = new Order("s1", getCurrentDateTime("9:45"), "tomato", 24.0, 100.0);
        Order s2 = new Order("s2", getCurrentDateTime("9:46"), "tomato", 20.0, 90.0);
        Order d1 = new Order("d1", getCurrentDateTime("9:47"), "tomato", 22.0, 110.0);
        Order d2 = new Order("d2", getCurrentDateTime("9:48"), "tomato", 21.0, 10.0);
        Order d3 = new Order("d3", getCurrentDateTime("9:49"), "tomato", 21.0, 40.0);
        Order s3 = new Order("s3", getCurrentDateTime("9:50"), "tomato", 19.0, 50.0);

        List<Order> orders = new ArrayList<>(List.of(s1, s2, d1, d2, d3, s3));

        return orders;
    }

    public static List<Trade> getTrades() {

        Trade t1 = new Trade("d1", "s2", 20.0, 90.0);
        Trade t2 = new Trade("d1", "s3", 19.0, 20.0);
        Trade t3 = new Trade("d2", "s3", 19.0, 10.0);
        Trade t4 = new Trade("d3", "s3", 19.0, 20.0);

        List<Trade> trades = new ArrayList<>(List.of(t1, t2, t3, t4));

        return trades;
    }

    public static String getFilePath(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String filePath = Objects.requireNonNull(classLoader.getResource(fileName)).getFile();
        return filePath;
    }


    private static Date getCurrentDateTime(String currentTime) {
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
