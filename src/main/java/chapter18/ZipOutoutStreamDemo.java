package chapter18;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:45
 */
public class ZipOutoutStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "hello.txt");
        File file1 = new File("d:" + File.separator + "hello.zip");
        InputStream inputStream = new FileInputStream(file);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file1));
        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
        zipOutputStream.setComment("hello");
        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            zipOutputStream.write(temp);
        }
        inputStream.close();
        zipOutputStream.close();
    }
}
