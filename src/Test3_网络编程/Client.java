package Test3_网络编程;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",888);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        String string ="Hello";
        printWriter.println(string);
        printWriter.flush();
        String response = bufferedReader.readLine();
        System.out.println("Server say:" + response);
        printWriter.close();
        bufferedReader.close();
        socket.close();
    }

}
