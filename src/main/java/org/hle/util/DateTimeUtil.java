package org.hle.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static LocalDateTime parseZonedStr(String dateTimeStrWithZone) {
        var formatter = DateTimeFormatter.ISO_DATE_TIME;

        return LocalDateTime.parse(dateTimeStrWithZone, formatter);
    }
}
