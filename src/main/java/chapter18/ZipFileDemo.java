package chapter18;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 20:02
 */
public class ZipFileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "hello.zip");
        ZipFile zipFile = new ZipFile(file);
        System.out.println(zipFile.getName());

        File outFile = new File("d:" + File.separator + "unZipFile.txt");
        ZipEntry entry = zipFile.getEntry("hello.txt");
        InputStream in = zipFile.getInputStream(entry);
        OutputStream out = new FileOutputStream(outFile);
        int temp = 0;
        while ((temp = in.read()) != -1) {
            out.write(temp);
        }
        in.close();
        out.close();
    }


}
