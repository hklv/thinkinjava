package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/23 17:10
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {

        File file1 = new File("D:" + File.separator + "hello.txt");
        File file2 = new File("D:" + File.separator + "hello1.txt");
        if (!file1.exists()) {
            System.out.println("被复制得文件不存在");
            System.exit(1);
        }
        InputStream in = new FileInputStream(file1);
        OutputStream out = new FileOutputStream(file2);
        if (in != null && out != null) {
            int temp = 0;
            while ((temp = in.read()) != -1) {
                out.write(temp);
            }
        }
        in.close();
        out.close();
    }
}
