package in.co.zitsolutions.task3_socket_Programming.two_way_communication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        ServerSocket ss = new ServerSocket(2024);

        System.out.println("Waiting for client request");
        Socket s = ss.accept();

        System.out.println("client connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = br.readLine();
        System.out.println("Client Data : "+data);

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter pw = new PrintWriter(os);
        pw.println(data.substring(0,3));
        pw.flush();
        System.out.println("data sent");
    }
}
