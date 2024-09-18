package vn.oceantech.baiTapL0.util;

public enum MenuUtil {
    EXIT("Save File And Come Back Option"), ADD("Add New Entry"), SHOW_ALL("Existing Student List"), REMOVE_STUDENT("Remove Entry"), FIND_STUDENT("Find Student By ID"), PERCENTAGE_BY_LEVEL("Displays The Percentage Sorted By Level"), LIST_STUDENT_BY_LEVEL("Displays List Of Student By Level"), PERCENTAGE_BY_GPA("Displays The Percentage Sorted By GPA"), UPDATE("Update Entry");

    private String value;

    MenuUtil(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.value = value;
    }
}
