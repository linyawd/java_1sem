import java.util.Scanner;

public class B0104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть три числа: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        double result = Math.cbrt(a * b * c);
        System.out.printf("Середнє геометричне: %.4f\n", result);
    }
}
