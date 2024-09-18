package vn.oceantech.baiTapL0.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AppUtil {
    public static String defaultFormatDouble(double value) {
        return String.format("%.2f", value);
    }

    public static Date format(Date in, String format) {
        SimpleDateFormat dfIn = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = dfIn.parse(dfIn.format(in));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parse(String in, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        df.setLenient(false);

        Date date = null;
        try {
            date = df.parse(in);
        } catch (ParseException e) {
            //e.printStackTrace();
        }
        return date;
    }

    public static String convertDateToString(Date in) {
        SimpleDateFormat df = new SimpleDateFormat(AppConstants.DEFAULT_DATE_FORMAT_DD_MM_YY);
        return df.format(in);
    }
    public static boolean isValidFormat(String dateStr) {
        if(AppConstants.DATE_PATTERN.matcher(dateStr).matches()) {
            return true;
        }
        return false;
    }


    public static Map<String, Integer> findFrequencyUtil(List<String> list, int counter) {
        Map<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < counter; i++) {
            if(!hm.containsKey(list.get(i))) {
                hm.put(list.get(i), 0);
            }
            hm.put(list.get(i), hm.get(list.get(i)) + 1);
        }
//        listObj.stream().map(obj->!hm.containsKey(obj) ? hm.put(obj, 0): hm.put(obj, hm.get(obj) + 1));
        return hm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
