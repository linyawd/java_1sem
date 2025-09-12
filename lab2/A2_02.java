package lab2;

import java.util.Scanner;

public class A2_02 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = n ^ (1 << k);

        System.out.println(result);
    }
}
