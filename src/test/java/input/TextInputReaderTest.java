package input;

import org.clover.dto.Order;
import org.clover.exception.DateParsingException;
import org.clover.exception.InvalidInputException;
import org.clover.input.TextInputReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import util.TestHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextInputReaderTest {

    @InjectMocks
    TextInputReader textInputReader;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void readTest() {

        String filePath = TestHelper.getFilePath("testInput_withNoException.txt");
        List<Order> inputs = TestHelper.getOrders();

        assertEquals(inputs.size(), textInputReader.read(filePath).size());
    }

    @Test(expected = InvalidInputException.class)
    public void readTestWithInvalidInputException() {
        String filePath = TestHelper.getFilePath("testInput_withInvalidInputException.txt");
        textInputReader.read(filePath);
    }

    @Test(expected = DateParsingException.class)
    public void readTestWithDateParsingException() {
        String filePath = TestHelper.getFilePath("testInput_withDateParsingException.txt");
        textInputReader.read(filePath);
    }
}
