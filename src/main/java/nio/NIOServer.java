package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/4/14 17:33
 */
public class NIOServer {

    ServerSocketChannel server;
    int port;
    Selector selector;
    ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
    ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    Map<SelectionKey, String> sessionMsg = new HashMap<>();

    public NIOServer(int port) throws IOException {
        this.port = port;
        server = ServerSocketChannel.open();
        server.socket().bind(new InetSocketAddress(this.port));
        server.configureBlocking(false);
        selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("NIO服务已经启动，监听端口是:" + this.port);

    }

    public void listener() throws IOException {
        while (true) {
            //判断客户有没有排队取号的
            int i = selector.select();
            if (i == 0) {
                continue;
            }
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iter = keys.iterator();
            while (iter.hasNext()) {
                process(iter.next());
                iter.remove();
            }
        }
    }

    private void process(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            receiveBuffer.clear();
            SocketChannel client = (SocketChannel) key.channel();
            int len = client.read(receiveBuffer);
            if (len > 0) {
                String msg = new String(receiveBuffer.array(), 0, len);
                sessionMsg.put(key, msg);
                System.out.println("获取客户端发来的消息：" + msg);
            }
            client.register(selector, SelectionKey.OP_WRITE);
        } else if (key.isWritable()) {
            if (!sessionMsg.containsKey(key)) {
                return;
            }
            SocketChannel client = (SocketChannel) key.channel();
            sendBuffer.clear();
            sendBuffer.put((sessionMsg.get(key) + ",你好，你的请求已经处理").getBytes());
            sendBuffer.flip();
            client.write(sendBuffer);
            client.register(selector, SelectionKey.OP_READ);
        }
     }

    public static void main(String[] args) throws IOException {
        new NIOServer(8081).listener();
    }
}
