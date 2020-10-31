package input;

import org.clover.constant.FileType;
import org.clover.exception.FileNotSupportException;
import org.clover.input.InputReaderFactory;
import org.clover.input.TextInputReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class InputReaderFactoryTest {

    @InjectMocks
    InputReaderFactory inputReaderFactory;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getInputReader() {
        assertEquals(TextInputReader.class, inputReaderFactory.getInputReader(FileType.TEXT).getClass());
    }

    @Test(expected = FileNotSupportException.class)
    public void getInputReaderWithFileNotSupportException() {
        inputReaderFactory.getInputReader(FileType.CSV);
    }
}
