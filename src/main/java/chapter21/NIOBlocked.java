package chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

/**
 * Created by hklv on 2016/7/26.
 */
public class NIOBlocked implements Runnable {

    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }


    public void run() {

        System.out.println("waiting for this in " + this);
        try {
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println("ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            System.out.println("AsynchronousCloseException");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting chapter21.NIOBlocked.run() " + this);
    }
}
