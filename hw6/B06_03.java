package hw6;

import java.util.Scanner;

public class B06_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine().trim();
        String regex = "^\\s*[+-]?\\d+(\\s*[+\\-*/]\\s*[+-]?\\d+)*\\s*$";
        if (expr.matches(regex)) System.out.println("Correct");
        else System.out.println("Incorrect");
    }
}