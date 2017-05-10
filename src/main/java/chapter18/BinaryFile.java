package chapter18;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-05 10:01.
 */
public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
}
