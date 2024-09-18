package vn.oceantech.baiTapL0;

import vn.oceantech.baiTapL0.ui.StudentConsole;

import java.io.IOException;
import java.text.ParseException;

public class Application {
    public static void main(String[] args) throws ParseException, IOException {
        StudentConsole st = new StudentConsole();
        st.start();
    }
}
