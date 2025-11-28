package hw10;


import java.io.*;
import java.net.*;
import java.util.*;


public class client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        out.println(s);
        String ans = in.readLine();
        System.out.println(ans);
        socket.close();
    }
}
