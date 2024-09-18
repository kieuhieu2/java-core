package vn.oceantech.baiTapL0.util;

public class StringPool {
    // String
    public static final String LEVEL = "Level";
    public static final String PERCENT = "Percent";
    public static final String DESC = "Decrease";
    public static final String NO = "n";
    public static final String RECORD = "record";
    public static final String GPA = "GPA";
    // enter from scanner
    public static final String ENTER_NAME = "Nhập vào tên:";
    public static final String ENTER_DATE_OF_BIRTH = "Nhập vào ngày sinh(dd-MM-yyyy):";
    public static final String DATE_FOMAT = "[dd-MM-yyyy]";
    public static final String ENTER_ADDRESS = "Nhập vào địa chỉ:";
    public static final String ENTER_HEIGHT = "Nhập vào chiều cao(cm):";
    public static final String ENTER_WEIGHT = "Nhập vào cân nặng(kg):";
    public static final String ENTER_STUDENT_CODE = "Nhập vào mã sinh viên:";
    public static final String ENTER_UNIVERSITY = "Nhập trường đang theo học:";
    public static final String ENTER_START_COURSE = "Nhập vào năm bắt đầu học:";
    public static final String ENTER_GPA = "Nhập vào điểm trung bình tích lũy:";
    public static final String CHOICE = "Chọn:";
    public static final String CHOICE_UPDATE = "Chon(1->" + MenuUtil.values().length + ")";
    public static final String OPTION = "Option:";
    public static final String FIND_STUDENT_BY_ID = "Nhập vào ID sinh viên cần tìm:";
    public static final String FIND_STUDENT_BY_ID_TO_UPDATE = "Nhập vào ID sinh viên cần update:";
    public static final String FIND_STUDENT_BY_ID_TO_DELETE = "Nhập vào ID sinh viên cần xóa:";

    // actions
    public static final String DELETE_FAILED = ">> Xóa sinh viên thất bại, sinh viên không có trong database";
    public static final String DELETE_SUCCESS = ">> Xóa sinh viên thành công.";
    public static final String UPDATE_FAILED = ">> Cập nhật thông tin sinh viên thất bại.";
    public static final String UPDATE_SUCCESS = ">> Cập nhật thông tin sinh viên thành công.";
    public static final String ADD_SUCCESS = ">> Thêm mới sinh viên thành công.";

    public static final String FOUND_RESULT = ">> Kết quả tìm tìm kiếm:";
    public static final String NOT_FOUND = ">> Không tìm thấy sinh viên nào.";

    // message error
    public static final String PLEASE_INTEGER_RANGE = ">> Hãy nhập vào số nguyên trong khoảng ";
    public static final String PLEASE_INTEGER_EQUAL = ">> Hãy nhập phím số ";
    public static final String PLEASE_REAL_RANGE =  ">> Hãy nhập vào một số thực trong khoảng ";
    public static final String PLEASE_STRING_LENGTH_RANGE =  ">> Hãy nhập vào một chuỗi có độ dài trong khoảng ";
    public static final String PLEASE_STRING_LENGTH_EQUAL = ">> Hãy nhập vào một chuỗi có độ dài đúng bằng ";
    public static final String DATA_EMPTY = ">> Danh sách sinh viên trống.";
    public static final String CHOICE_NOT_EXIST = ">> Chức năng không có trong danh sách.";

    // message please
    public static final String TO_OPTION = ">> Quay lại Option nhấn phím 1";
    public static final String TO_BACK_MAIN_MENU = ">> Quay lại nhấn phím 1 và Main Menu nhấn phím 0";
    public static final String UPDATE_TO_BACK_MAIN_MENU = ">> Cập nhật sinh viên mới nhấn phím 1 và Main Menu nhấn phím 0";
    public static final String TO_BACK_OPTION = ">> Quay lại nhấn phím 1 và Option nhấn phím 0";
    public static final String TO_MAIN_MENU = ">> Quay lại Main Menu Nhấn phím 1";
    public static final String CONTINUE_UPDATE = ">> Tiếp tục chỉnh sửa nhấn phím 1, cập nhật hoaàn tất nhấn phím 0";
    public static final String TO_LEAVE = ">> Ban có muốn rời ứng dụng(Y\\N)? >";

    // symbol
    public static final String RIGHT_ARROW = "->";
    public static final String EMPTY = "";

    // error
    public static final String ERROR_EMPTY = ">> Giá trị null";
    public static final String ERROR_SPECIAL_CHARACtERS = ">> Chuỗi không thể chứa các ký tự đặc biệt";
    public static final String ERROR_START_DATE = ">> Ngày phải bắt đầu từ";
    public static final String ERROR_END_DATE_BEFORE_CURRENT_DATE = ">> Ngày phải trước ngày hiện tại";
    public static final String ERROR_DATE_NOT_EXIST = ">> Ngày không tồn tại";
    public static final String ERROR_DATE_NOT_FORMAT = ">> Ngày không đúng định dạng ";
    public static final String ERROR_DUPLICATE_CODE = ">> Mã đang bị trùng với một sinh viên khác.";;

    public static final String DOUBLE_TAB = "\t\t";

    // exit
}
