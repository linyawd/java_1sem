package hw5;
import java.util.*;

public class B05_02 {
    static boolean onlyLetters(String s, int from) {
        for (int i = from; i < s.length(); i++) if (!Character.isLetter(s.charAt(i))) return false;
        return true;
    }

    static boolean checkA(String s) {
        if (s.isEmpty()) return false;
        char c = s.charAt(0);
        if (c < '1' || c > '9') return false;
        int need = c - '0';
        return s.length() - 1 == need && onlyLetters(s, 1);
    }

    static boolean checkB(String s) {
        int cnt = 0, val = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) { cnt++; val = ch - '0'; if (cnt > 1) return false; }
            else if (!Character.isLetter(ch)) return false;
        }
        return cnt == 1 && val == s.length();
    }

    static boolean checkC(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) sum += ch - '0';
            else if (!Character.isLetter(ch)) return false;
        }
        return sum == s.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(checkA(s));
        System.out.println(checkB(s));
        System.out.println(checkC(s));
    }
}
