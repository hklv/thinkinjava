package chapter18;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:51
 */
public class ZipOutputStream2 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "temp");
        File zipFile = new File("d:" + File.separator + "zipFile.zip");
        InputStream in = null;
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
        out.setComment("hello");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                in = new FileInputStream(file1);
                out.putNextEntry(new ZipEntry(file.getName() + File.separator + file1.getName()));
                int temp = 0;
                while ((temp = in.read()) != -1) {
                    out.write(temp);
                }
                in.close();

            }
        }
        out.close();
    }

}
