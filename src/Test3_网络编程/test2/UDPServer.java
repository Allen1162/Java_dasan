package Test3_网络编程.test2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(9000);   // 9000端口监听
        String str = "www.mldn.cn";        // 发送消息
        DatagramPacket packet = new DatagramPacket(str.getBytes(), 0, str.length(), InetAddress.getByName("localhost"), 9999);  // 发送数据
        server.send(packet);          // 发送消息
        System.out.println("消息发送完毕.....");
        server.close();          // 关闭服务端
    }

}
