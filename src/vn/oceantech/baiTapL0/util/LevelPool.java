package vn.oceantech.baiTapL0.util;

public enum LevelPool {
    KEM("Kém", 0.0),
    YEU("Yếu", 3.0),
    TRUNG_BINH("Trung Bình", 5),
    KHA("Khá", 6.5),
    GIOI("Giỏi", 7.5),
    XUAT_SAC("Xuất sắc", 9.0);

    private String key;
    private double desc;

    LevelPool(String key, double desc) {
        this.key=key;
        this.desc=desc;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }

    public double getDesc() {

        return desc;
    }

    public void setDesc(double desc) {

        this.desc = desc;
    }
}
