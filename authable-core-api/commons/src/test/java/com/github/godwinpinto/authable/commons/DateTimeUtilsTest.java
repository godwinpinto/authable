package com.github.godwinpinto.authable.commons;

import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DateTimeUtilsTest {

    @Test
    public void currentDateTest() {
        Timestamp ts = Timestamp.from(Instant.now());
        Timestamp t = DateTimeUtils.getCurrentDate();
        Assertions.assertThat(t.getTime())
                .isBetween(ts.getTime(), ts.getTime() + 500L);

    }

    @Test
    public void dateAddTest() {
        Timestamp t = DateTimeUtils.getCurrentDate();
        Timestamp t1 = DateTimeUtils.addDays(t, 1);
        Timestamp t2 = DateTimeUtils.addDays(t1, -1);
        assertEquals(t2.getTime(), t.getTime());
    }

    @Test
    public void hourAddTest() {
        Timestamp t = DateTimeUtils.getCurrentDate();
        Timestamp t1 = DateTimeUtils.addHour(t, 1);
        Timestamp t2 = DateTimeUtils.addHour(t1, -1);
        assertEquals(t2.getTime(), t.getTime());
    }

    @Test
    public void stripTimeAndAddTest() throws Exception {
        Timestamp t = DateTimeUtils.getCurrentDate();

        String strippedTime = DateTimeUtils.stripTimeSec(t);
        Timestamp t2 = DateTimeUtils.parseStringToDateTime(strippedTime);
        String strippedTime2 = DateTimeUtils.stripTimeSec(t2);
        assertEquals(strippedTime, strippedTime2);
    }

    @Test
    public void localDateTest() throws Exception {
        Timestamp ts = Timestamp.from(Instant.now());
        LocalDateTime t = DateTimeUtils.getCurrentLocalDateTime();

        LocalDateTime time = LocalDateTime.now();
        Assertions.assertThat(time.isBefore(t) || time.isEqual(t));

    }
}
