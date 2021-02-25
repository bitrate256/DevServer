package bno.asset.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormat {
    public static String today(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format((Calendar.getInstance()).getTime());
    }
    public static String today() {
        return today("yyyy-MM-dd");
    }
}
