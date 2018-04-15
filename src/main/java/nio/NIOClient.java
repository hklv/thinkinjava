package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/4/14 18:01
 */
public class NIOClient {
    SocketChannel client;
    InetSocketAddress remote = new InetSocketAddress(8081);
    Selector selector;
    ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
    ByteBuffer sendBuffer = ByteBuffer.allocate(1024);

    public NIOClient() throws IOException {
        client = SocketChannel.open();
        client.configureBlocking(false);
        client.connect(remote);
        selector = Selector.open();
        client.register(selector, SelectionKey.OP_CONNECT);

    }

    public void session() throws IOException {
        if (client.isConnectionPending()) {
            client.finishConnect();
            System.out.println("请在服务台输入姓名");
            client.register(selector, SelectionKey.OP_WRITE);

        }

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            if ("".equals(name)) {
                continue;
            }
            process(name);
        }
    }

    private void process(String name) throws IOException {
        boolean unFinish = true;
        while (unFinish) {
            int i = selector.select();
            if (i == 0) {
                continue;
            }
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iter = keys.iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                if (key.isWritable()) {
                    sendBuffer.clear();
                    sendBuffer.put(name.getBytes());
                    sendBuffer.flip();
                    client.write(sendBuffer);
                    client.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    receiveBuffer.clear();
                    int len = client.read(receiveBuffer);
                    if (len > 0) {
                        receiveBuffer.flip();
                        System.out.println("获取服务端反馈的消息：" + new String(receiveBuffer.array(),0,len));
                        client.register(selector, SelectionKey.OP_WRITE);
                        unFinish = false;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new NIOClient().session();
    }
}
