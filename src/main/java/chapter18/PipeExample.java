/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2019 All Rights Reserved.
 */
package chapter18;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author LvHuiKang
 * @version $Id: PipeExample.java, v 0.1 2019-03-11 16:50 LvHuiKang Exp $$
 */
public class PipeExample {
    public static void main(String[] args) {
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    out.write("Hello world".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = in.read();
                    while (data != -1) {
                        System.out.println((char) data);
                        data = in.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}