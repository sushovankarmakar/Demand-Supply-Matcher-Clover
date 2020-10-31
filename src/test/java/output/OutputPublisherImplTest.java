package output;

import org.clover.output.OutputPublisherImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static util.TestHelper.getTrades;

public class OutputPublisherImplTest {

    @InjectMocks
    OutputPublisherImpl outputPublisher;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void publishTest() {
        outputPublisher.publish(getTrades());
    }
}
