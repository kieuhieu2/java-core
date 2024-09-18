package vn.oceantech.baiTapL0.util;

import vn.oceantech.baiTapL0.service.impl.ArrayServiceImpl;
import vn.oceantech.baiTapL0.service.impl.ListServiceImpl;

public enum OptionsUtil {
        ARRAY_SECTION("Array Section", new ArrayServiceImpl()), LIST_SECTION("List section", new ListServiceImpl()), EXIT_PROGRAM("Exit", null);

        private String key;
        private Object desc;

        OptionsUtil(String key, Object desc) {
            this.key=key;
            this.desc=desc;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getDesc() {
            return desc;
        }

        public void setDesc(Object desc) {
            this.desc = desc;
        }

}
