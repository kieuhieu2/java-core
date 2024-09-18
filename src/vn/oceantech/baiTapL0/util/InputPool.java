package vn.oceantech.baiTapL0.util;

import vn.oceantech.baiTapL0.service.Validation;
import java.text.ParseException;
import java.util.Date;

public enum InputPool {
    NAME("Name") {
        public String input() {
            return Validation.getString(StringPool.ENTER_NAME, AppConstants.DEFAULT_MIN_LENGTH, AppConstants.MAX_LENGTH_NAME);
        }
    },
    DATE_OF_BIRTH("Date Of Birth") {
        public Date input() throws ParseException {
            return Validation.getDate(StringPool.ENTER_DATE_OF_BIRTH, AppConstants.START_DATE, AppConstants.END_DATE, AppConstants.DEFAULT_DATE_FORMAT_DD_MM_YY);
        }
    },
    ADDRESS("Address") {
        public String input() {
            return Validation.getString(StringPool.ENTER_ADDRESS,AppConstants.DEFAULT_MIN_LENGTH, AppConstants.MAX_LENGTH_ADDRESS);
        }
    },
    HEIGHT("Height") {
        public Double input() {
            return Validation.getDouble(StringPool.ENTER_HEIGHT, AppConstants.MIN_HEIGHT, AppConstants.MAX_HEIGHT);
        }
    },
    WEIGHT("Weight") {
        public Double input() {
            return Validation.getDouble(StringPool.ENTER_WEIGHT, AppConstants.MIN_WEIGHT, AppConstants.MAX_WEIGHT);
        }
    },
    STUDENT_CODE("Student Code") {
        public String input() {
            return Validation.getString(StringPool.ENTER_STUDENT_CODE, AppConstants.LENGTH_CODE);
        }
    },
    UNIVERSITY("University") {
        public String input() {
            return Validation.getString(StringPool.ENTER_UNIVERSITY,AppConstants.DEFAULT_MIN_LENGTH, AppConstants.MAX_LENGTH_UNIVERSITY);
        }
    },
    START_COURSE("Start Course") {
        public Integer input() {
            return Validation.getInt(StringPool.ENTER_START_COURSE, AppConstants.MIN_YEAR, AppConstants.MAX_YEAR);
        }
    },
    GPA("Gpa") {
        public Double input() {
            return Validation.getDouble(StringPool.ENTER_GPA, AppConstants.MIN_GPA, AppConstants.MAX_GPA);
        }
    };

    private String value;

    InputPool(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public abstract Object input() throws ParseException;
}




