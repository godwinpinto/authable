package com.github.godwinpinto.authable.commons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DateTimeUtilsTest {

  @Test
  void currentDateTest() {
    Timestamp ts = Timestamp.from(Instant.now());
    Timestamp t = DateTimeUtils.getCurrentDate();
    Assertions.assertThat(t.getTime()).isBetween(ts.getTime(), ts.getTime() + 500L);
  }

  @Test
  void dateAddTest() {
    Timestamp t = DateTimeUtils.getCurrentDate();
    Timestamp t1 = DateTimeUtils.addDays(t, 1);
    Timestamp t2 = DateTimeUtils.addDays(t1, -1);
    assertEquals(t2.getTime(), t.getTime());
  }

  @Test
  void hourAddTest() {
    Timestamp t = DateTimeUtils.getCurrentDate();
    Timestamp t1 = DateTimeUtils.addHour(t, 1);
    Timestamp t2 = DateTimeUtils.addHour(t1, -1);
    assertEquals(t2.getTime(), t.getTime());
  }

  @Test
  void stripTimeAndAddTest() throws Exception {
    Timestamp t = DateTimeUtils.getCurrentDate();

    String strippedTime = DateTimeUtils.stripTimeSec(t);
    Timestamp t2 = DateTimeUtils.parseStringToDateTime(strippedTime);
    String strippedTime2 = DateTimeUtils.stripTimeSec(t2);
    assertEquals(strippedTime, strippedTime2);
  }

  @Test
  void localDateTest() throws Exception {
    LocalDateTime t = DateTimeUtils.getCurrentLocalDateTime();

    LocalDateTime time = LocalDateTime.now();
    assertTrue(time.isAfter(t));
  }
}
