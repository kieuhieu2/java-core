package vn.oceantech.baiTapL0.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class AppConstants {
    // format
    public static final int FORMAT_SIZE = -45;

    public static final int DEFAULT_MIN_LENGTH = 1;

    public static final int MAX_LENGTH_NAME = 100;

    public static final int MAX_LENGTH_ADDRESS = 300;

    // height range
    public static final double MIN_HEIGHT = 50.0;
    public static final double MAX_HEIGHT = 300.0;

    // weight range
    public static  final double MIN_WEIGHT = 5.0;
    public static final double MAX_WEIGHT = 1000.0;

    // length code range
    public static final int LENGTH_CODE = 10;

    public static final int MAX_LENGTH_UNIVERSITY = 200;

    // year range
    public static final int MIN_YEAR = 1900;
    public static final int MAX_YEAR = Calendar.getInstance().get(Calendar.YEAR);

    // date range
    public static  final Date START_DATE = AppUtil.parse("01-01-1900", AppConstants.DEFAULT_DATE_FORMAT_DD_MM_YY);
    public static final Date END_DATE = AppUtil.format(new Date(), AppConstants.DEFAULT_DATE_FORMAT_DD_MM_YY);

    // gpa range
    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 10.0;

    // type def number
    public static final int NUMBER_0 = 0;
    public static final int NUMBER_1 = 1;
    public static final int NOT_FOUND = -1;
    public static final int CONTINUE = 1;
    public static final int INPUT_MODE_CODE = 1;
    public static final int UPDATE_MODE_CODE = 2;

    // default
    public static final int DEFAULT_STATUS = 1;
    public static final int DEFAULT_SIZE_ARRAY = 1;
    public static final int AUTO_INCREMENT_SIZE = 1;
//    public static final int DO_NOT_SEND_EMAIL = 0;

    public static final String CHARSET_UTF8 = "UTF-8";


    // date format
    public static final String DEFAULT_DATE_FORMAT_DD_MM_YY = "dd-MM-yyyy";
    public static final String DD_MM_YY = "dd-MM-yy";

    // pattern
    public static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
    public static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

    public static final int DEFAULT_COLUMN_MENU = 3;

    public static final int INIT_COUNTER = 0;
    public static final int INIT_STATUS = 1;
}
