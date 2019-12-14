package Homework6_网络编程.TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8002);
        Socket socket = serverSocket.accept();
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        String string = "Hello World!";
        System.out.println("服务端发送：" + string);
        writer.println(string);
        writer.flush();
        writer.close();
        socket.close();
        serverSocket.close();
    }

}
