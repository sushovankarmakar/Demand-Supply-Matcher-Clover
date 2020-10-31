package org.clover.constant;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    COMPARATOR_NOT_FOUND("No comparator is found"),
    INVALID_INPUT_FORMAT("Input format is invalid"),
    FILE_NAME_IS_NULL("File name should not be null"),
    FILE_TYPE_IS_NULL("File type should not be null"),
    UNSUPPORTED_FILE_FORMAT("This type of file is not supported"),
    NO_PATH_PROVIDED("Input file's path is not provided"),
    DATE_NOT_PARSED("Date parsing is unsuccessful"),
    ORDER_LIST_IS_NULL("Order list is null");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
