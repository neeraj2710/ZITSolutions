package in.co.zitsolutions.task3_socket_Programming.one_way_communication;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
        os.flush();
    }
}
