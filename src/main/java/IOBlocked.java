import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hklv on 2016/7/24.
 */
public class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream inputStream) {
        in = inputStream;
    }

    public void run() {
        System.out.println("waiting for read");
        try {
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupt from IOBlocked");
            } else {
                throw new RuntimeException();
            }
        }
        System.out.println("Exiting IOBlocked.run");
    }
}
