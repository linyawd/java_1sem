package hw10;

import java.io.*;
import java.net.*;
import java.util.*;


public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket socket = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String line;
        while ((line = in.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (String p : parts) {
                int x = Integer.parseInt(p);
                if (x < min) min = x;
                if (x > max) max = x;
            }
            out.println(min + " " + max);
        }
        socket.close();
        ss.close();
    }
}
