package chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-05 11:13.
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.write(ByteBuffer.wrap("Some More".getBytes()));
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining()){
            System.out.print((char)buff.get());
        }
    }
}
