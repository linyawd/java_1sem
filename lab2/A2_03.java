package lab2;
import java.util.Scanner;


public class A2_03 {
    

     // Рекурсивна функція
    public static int fibRec(int n) {
        if (n <= 1) return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    // Ітеративна функція
    public static int fibIter(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Рекурсивно: " + fibRec(n));
        System.out.println("Ітеративно: " + fibIter(n));
    }
}
