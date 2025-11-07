package hw7;

import java.io.*;
import java.util.*;

public class B07_01 {
    static void writeDoubles(String name, double[] arr) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(name));
        for (double x : arr) out.writeDouble(x);
        out.close();
    }

    static double[] readDoubles(String name) throws IOException {
        List<Double> list = new ArrayList<>();
        DataInputStream in = new DataInputStream(new FileInputStream(name));
        try {
            while (true) list.add(in.readDouble());
        } catch (EOFException e) {
        }
        in.close();
        double[] a = new double[list.size()];
        for (int i = 0; i < a.length; i++) a[i] = list.get(i);
        return a;
    }

    static void buildG(String f, String g, double a) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(f));
        DataOutputStream out = new DataOutputStream(new FileOutputStream(g));
        try {
            while (true) {
                double x = in.readDouble();
                if (x > a) out.writeDouble(x);
            }
        } catch (EOFException e) {
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextDouble();
        double a = sc.nextDouble();
        writeDoubles("F.bin", arr);
        buildG("F.bin", "G.bin", a);
        System.out.println(Arrays.toString(readDoubles("G.bin")));
    }
}
