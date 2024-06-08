package org.hle.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeUtilTest {

    @Test
    void parseLocalDateTime() {
        var expected = "2024-11-22T13:44:55";
        var dtStr = "2024-11-22T13:44:55";
        var dt = DateTimeUtil.parseZonedStr(dtStr);

        assertEquals(expected, dt.toString());
    }

    @Test
    void parseZonedDateTime() {
        var expected = "2024-11-22T13:44:55";
        var dtStr = "2024-11-22T13:44:55+01:00[Europe/Paris]";
        var dt = DateTimeUtil.parseZonedStr(dtStr);

        assertEquals(expected, dt.toString());
    }

    @Test
    void parseUtcDateTime() {
        var expected = "2024-11-22T13:44:55";
        var dtStr = "2024-11-22T13:44:55Z";
        var dt = DateTimeUtil.parseZonedStr(dtStr);

        assertEquals(expected, dt.toString());
    }

    @Test
    void parseOffsetDateTime() {
        var expected = "2024-11-22T13:44:55";
        var dtStr = "2024-11-22T13:44:55+01:00";
        var dt = DateTimeUtil.parseZonedStr(dtStr);

        assertEquals(expected, dt.toString());
    }
}