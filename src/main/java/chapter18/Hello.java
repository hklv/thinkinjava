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
        byte[] bytes = new byte[1024];
        in.read(bytes);
        in.close();
        System.out.println(new String(bytes));
        InputStream in1 = new FileInputStream(file);
        byte[] bytes1 = new byte[1024];
        int length = in1.read(bytes1);
        in1.close();
        System.out.println(new String(bytes1, 0, length));
        InputStream in2 = new FileInputStream(file);
        byte[] bytes2 = new byte[(int) file.length()];
        in2.read(bytes2);
        System.out.println("文件长度：" + file.length());
        System.out.println(new String(bytes2));
        InputStream in3 = new FileInputStream(file);
        byte[] bytes3 = new byte[(int) file.length()];
        for (int i = 0; i < bytes3.length; i++) {
            bytes3[i] = (byte) in3.read();
        }
        in3.close();
        System.out.println(new String(bytes3));

        InputStream in4 = new FileInputStream(file);
        int count = 0;
        int temp;
        byte[] bytes4 = new byte[1024];
        while ((temp = in4.read()) != (-1)) {
            bytes4[count++] = (byte) temp;
        }
        System.out.println(new String(bytes4));
        Writer writer = new FileWriter(file);
        writer.write("hello");
        writer.close();

        char[] ch = new char[100];
        Reader reader = new FileReader(file);
        int c = reader.read(ch);
        reader.close();
        System.out.println(new String(ch, 0, c));
    }
}
