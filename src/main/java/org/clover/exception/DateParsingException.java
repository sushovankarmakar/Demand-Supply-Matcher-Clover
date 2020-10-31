package org.clover.exception;

import org.clover.constant.ErrorMessage;

/**
 * DESCRIPTION :
 * {@code InvalidInputException} is a class of {@code RuntimeException} which is thrown
 * when there is a mismatch in the inputs given by the user.
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

public class DateParsingException extends RuntimeException {

    public DateParsingException(ErrorMessage message) {
        super(message.getMessage());
    }
}
