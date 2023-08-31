package kia.com.mybatistest.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeUtils {
    public static Timestamp localDateTimeToTimeStamp(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    public static LocalDateTime timeStampToLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }
}
