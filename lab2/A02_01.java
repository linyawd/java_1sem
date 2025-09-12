package lab2;

import java.util.Scanner;

public class A02_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть k: ");
        int k = sc.nextInt();

        System.out.print("Введіть кількість елементів масиву: ");
        int n = sc.nextInt();

        int count = 0;

        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (k != 0 && x % k == 0) {
                count++;
            }
            if (k == 0 && x == 0) {
                count++;
            }
        }

        System.out.println("Кількість чисел кратних k: " + count);
    }
}
