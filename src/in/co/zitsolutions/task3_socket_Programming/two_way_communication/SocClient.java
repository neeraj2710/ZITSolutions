package in.co.zitsolutions.task3_socket_Programming.two_way_communication;

import java.io.*;
import java.net.Socket;

public class SocClient {
    public static void main(String[] args) throws IOException {
        String ip = "localhost";
        int port = 2024;
        Socket s = new Socket(ip,port);

        String str = "Neeraj Wadhwaney";

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter pw = new PrintWriter(os);
        pw.println(str);
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str2 = br.readLine();
        System.out.println("Data from server : "+str2);
    }
}
