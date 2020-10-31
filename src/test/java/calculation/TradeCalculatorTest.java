package calculation;

import org.clover.calculation.TradeCalculator;
import org.clover.dto.Order;
import org.clover.dto.Trade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static util.TestHelper.getOrders;
import static util.TestHelper.getTrades;

public class TradeCalculatorTest {

    @InjectMocks
    TradeCalculator tradeCalculator;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void calculateTest() {

        List<Order> orders = getOrders();
        List<Trade> trades = getTrades();

        assertEquals(trades.get(0).getDemandOrderId(), tradeCalculator.calculate(orders).get(0).getDemandOrderId());
    }
}
