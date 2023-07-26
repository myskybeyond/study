package xyz.lijiantao.study.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 在Web服务器中，每个请求通常都是一个独立的任务，通过使用多线程可以同时处理多个请求，提高服务器的吞吐量和响应速度。
 * @Date 2023/7/26 14:05
 * @Created by LIJIANTAO
 */
public class SimpleWebServer {

    public static void main(String[] args) {
        final int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Web server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // 创建新线程处理客户端请求
                Thread requestHandlerThread = new Thread(new RequestHandler(clientSocket));
                requestHandlerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class RequestHandler implements Runnable {
        private final Socket clientSocket;

        public RequestHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                // 从客户端读取请求内容
                String request = in.readLine();
                System.out.println("Received request from client: " + request);

                // 模拟处理请求的耗时任务
                Thread.sleep(2000);

                // 返回响应给客户端
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println();
                out.println("<html><body>");
                out.println("<h1>Hello, Web Server!</h1>");
                out.println("</body></html>");

                clientSocket.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
