package xyz.lijiantao.study.netty.io;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Jiantao Li
 * @date 2020/3/12 16:21
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("192.168.123.48", 8080);
                while (true) {
                    try {
                        socket.getOutputStream().write((System.currentTimeMillis() + "hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(5000);
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
