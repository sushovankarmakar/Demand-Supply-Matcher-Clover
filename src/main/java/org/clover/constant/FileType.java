package org.clover.constant;

import lombok.Getter;

/**
 * {@code FileType} enum contains different types of file type
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

@Getter
public enum FileType {

    /**
     * TEXT is kind of file type whose extensions are .txt
     */
    TEXT("txt"),

    /**
     * CSV is kind of file type whose extensions are .csv
     */
    CSV("csv");

    private final String type;

    FileType(String type) {
        this.type = type;
    }
}
