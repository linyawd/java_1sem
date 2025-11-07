package hw7;

import java.io.*;
import java.util.*;

public class B07_02 {
    static class Toy {
        String name;
        double price;
        int minAge;
        int maxAge;
        Toy(String n, double p, int min, int max) { name=n; price=p; minAge=min; maxAge=max; }
    }

    static void writeToys(String file, List<Toy> a) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
        for (Toy t : a) {
            out.writeUTF(t.name);
            out.writeDouble(t.price);
            out.writeInt(t.minAge);
            out.writeInt(t.maxAge);
        }
        out.close();
    }

    static List<Toy> readToys(String file) throws IOException {
        List<Toy> res = new ArrayList<>();
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        try {
            while (true) {
                String name = in.readUTF();
                double price = in.readDouble();
                int min = in.readInt();
                int max = in.readInt();
                res.add(new Toy(name, price, min, max));
            }
        } catch (EOFException e) {
        }
        in.close();
        return res;
    }

    static List<Toy> filterByAge(List<Toy> a, int k) {
        List<Toy> r = new ArrayList<>();
        for (Toy t : a) if (t.minAge <= k && k <= t.maxAge) r.add(t);
        return r;
    }

    static void printToys(List<Toy> a) {
        for (Toy t : a) System.out.println(t.name + " " + t.price + "грн  (" + t.minAge + "-" + t.maxAge + ")");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Toy> toys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double price = sc.nextDouble();
            int min = sc.nextInt();
            int max = sc.nextInt();
            toys.add(new Toy(name, price, min, max));
        }
        int k = sc.nextInt();
        writeToys("ToysAll.bin", toys);
        List<Toy> fromAll = readToys("ToysAll.bin");
        List<Toy> ok = filterByAge(fromAll, k);
        writeToys("ToysForAge.bin", ok);
        printToys(readToys("ToysForAge.bin"));
    }
}
