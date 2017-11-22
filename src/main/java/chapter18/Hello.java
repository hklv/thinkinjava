package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/20 11:07
 */
public class Hello {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\hello.txt");
        //file.createNewFile();
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        String fileName = "D:" + File.separator + "hello1.txt";
        File file1 = new File(fileName);
        //file1.createNewFile();
        String fileName1 = "D:" + File.separator + "hello";
        File file2 = new File(fileName1);
        String fileName2 = "D:" + File.separator;
        File file3 = new File(fileName2);
        String[] fileList = file3.list();
        File[] fileList1 = file3.listFiles();
        assert fileList != null;
        for (String temp : fileList) {
            System.out.println(temp);
        }
        assert fileList1 != null;
        for (File file4 : fileList1) {
            System.out.println(file4);
        }
        file2.mkdir();
        System.out.println(file1.isDirectory());
        System.out.println(file2.isDirectory());
        if (file1.exists()) {
            file1.delete();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.writeBytes("asdsa");
        randomAccessFile.writeInt(12);
        randomAccessFile.writeBoolean(true);
        randomAccessFile.writeChar('A');
        randomAccessFile.writeFloat(1.21f);
        randomAccessFile.writeDouble(12.123);
        OutputStream out = new FileOutputStream(file);
        out.write("你好".getBytes());
        out.close();
        OutputStream out1 = new FileOutputStream(file, true);
        String str = "Rollen";
        byte[] b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out1.write(b[i]);
        }
        out1.close();
        InputStream in = new FileInputStream(file);
    }
}
