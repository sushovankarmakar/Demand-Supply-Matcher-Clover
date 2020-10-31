package org.clover.exception;

import org.clover.constant.ErrorMessage;

/**
 * DESCRIPTION :
 * {@code FileNotSupportException} is a class of {@code RuntimeException} which is thrown
 * when a specified type of file is not supported by our programme.
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */
public class FileNotSupportException extends RuntimeException {

    public FileNotSupportException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
