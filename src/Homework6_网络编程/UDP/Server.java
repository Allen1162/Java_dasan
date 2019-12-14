package Homework6_网络编程.UDP;

import java.io.IOException;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        int port = 8001;
        DatagramSocket datagramSocket = new DatagramSocket(port, inetAddress);
//        datagramSocket.connect(inetAddress,port);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        String string = new String(bytes, 0, datagramPacket.getLength());
        System.out.println("接收到的数据为：" + string);
        datagramSocket.close();
    }

}
