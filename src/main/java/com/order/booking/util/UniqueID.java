package com.order.booking.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueID {
    private static AtomicInteger autoIncrement;
    private static int defaultValue = 100;

    static {
        LocalDateTime date = LocalDateTime.now();
        autoIncrement = new AtomicInteger(date.getYear() + date.getMonthValue() + date.getDayOfMonth() + date.getHour() + date.getMinute()
                + date.getSecond() + (++defaultValue));
    }

    public static Integer getNextId() {
        return autoIncrement.getAndIncrement();
    }
}

