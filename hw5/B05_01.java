package hw5;
import java.util.*;

public class B05_01 {
    static boolean valid(String s) {
        boolean in = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (in) return false;
                in = true;
            } else if (c == ')') {
                if (!in) return false;
                in = false;
            }
        }
        return !in;
    }

    static String removeGroups(String s) {
        StringBuilder r = new StringBuilder();
        boolean in = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { in = true; continue; }
            if (c == ')') { in = false; continue; }
            if (!in) r.append(c);
        }
        return r.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (!valid(line)) { System.out.println("Incorrect"); return; }
        System.out.println(removeGroups(line));
    }
}
