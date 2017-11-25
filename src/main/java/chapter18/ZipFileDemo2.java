package chapter18;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 20:58
 */
public class ZipFileDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "zipFile.zip");
        File outFile = null;
        ZipFile zipFile = new ZipFile(file);
    }
}
