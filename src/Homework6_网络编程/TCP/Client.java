package Homework6_网络编程.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8002);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String string = bufferedReader.readLine();
        System.out.println("客户端接收："+string);
        bufferedReader.close();
        socket.close();
    }
}
