package Test3_网络编程;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(888);
        while(true){
            Socket socket = serverSocket.accept();
            SocketHandler socketHandler = new SocketHandler(socket);
            Thread thread = new Thread(socketHandler);
            thread.start();
        }
    }
}

class SocketHandler implements Runnable{

    private Socket socket;

    public SocketHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            String client = "<" + socket.getInetAddress().toString()+": "+socket.getPort()+">";
            String request = bufferedReader.readLine();
            System.out.println(client+"say: "+request);
            String line = client+"Hello,too!";
            printWriter.println(line);
            printWriter.flush();
            printWriter.close();
            bufferedReader.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
