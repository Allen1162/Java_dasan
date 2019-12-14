package Homework6_网络编程.UDP;

import java.io.IOException;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String string = "Hello World";
        byte[] bytes = string.getBytes();
        int port = 8001;
        InetAddress inetAddress = InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, port);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

}
