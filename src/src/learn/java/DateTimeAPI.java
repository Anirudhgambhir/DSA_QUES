package learn.java;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPI {
    public static void main(String[] args) throws InterruptedException {
        // Current date
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        // Current time
        LocalTime nowTime = LocalTime.now();
        System.out.println("Current Time: " + nowTime);

        // Current date and time
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + nowDateTime);

        // Current date and time with time zone
        ZonedDateTime zonedNow = ZonedDateTime.now();
        System.out.println("Current Zoned Date and Time: " + zonedNow);
        System.out.println("Current Offset Date and Time: " + OffsetDateTime.now());

        // Formatting example
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = nowDateTime.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        System.out.println("INSTANT - " + Instant.now().atOffset(ZoneOffset.of("+0530")));
    }
}
