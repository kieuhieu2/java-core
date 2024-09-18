package vn.oceantech.baiTapL0.util;

import java.io.*;

public class FileUtil {
    public static boolean doesFileExist(String file) {
        File temp = new File(file);
        return temp.exists();
    }

    public static String getFileContent(String file) throws IOException {
        StringBuilder fileSb = new StringBuilder();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = null;
        while((line = br.readLine()) != null) {
            fileSb.append(line).append("\n");
        }

        fr.close();
        br.close();

        return fileSb.toString();
    }

    public static boolean appendToFile(String file, String content, boolean appendOnNewLine) throws IOException {
        if(doesFileExist(file)) {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(getFileContent(file));
            if(appendOnNewLine) {
                bw.newLine();
            }
            bw.write(content);

            bw.close();
            fw.close();

            return true;
        }
        return false;
    }

    public static boolean appendToFile(String file, String content) throws IOException {
        return appendToFile(file, content, true);
    }
    public static boolean writeToFile(String file, String content) throws IOException {

        boolean didOverWrite = doesFileExist(file);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(content);

        bw.flush();

        bw.close();
        fw.close();
        return didOverWrite;
    }
}
