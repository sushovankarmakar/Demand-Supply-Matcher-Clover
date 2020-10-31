package org.clover.input;

import lombok.NonNull;
import org.clover.constant.FileType;
import org.clover.exception.FileNotSupportException;

import java.util.Objects;

import static org.clover.constant.ErrorMessage.FILE_TYPE_IS_NULL;
import static org.clover.constant.ErrorMessage.UNSUPPORTED_FILE_FORMAT;

/**
 * DESCRIPTION :
 * {@code InputReaderFactory} class produces different types of {@code InputReader} objects on the
 * basis of file type given in the parameter.
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

public class InputReaderFactory {

    /**
     * This method returns a specific kind of {@code InputReader} based upon the {@code FileType} provided in the parameter.
     * @param type
     * @return specific kind input reader object.
     * @throws {@code FileNotSupportException} if given type of file is not supported by the method.
     */

    public InputReader getInputReader(@NonNull FileType type) {

        Objects.requireNonNull(type, FILE_TYPE_IS_NULL.getMessage());

        switch (type) {
            case TEXT:
                return new TextInputReader();
            default:
                throw new FileNotSupportException(UNSUPPORTED_FILE_FORMAT);
        }
    }
}
