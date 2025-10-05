package hw2;
import java.util.*;

public class B02_17b {
    static double f(double x, double eps) {
        double sum = 0.0;
        int k = 0;
        double term;
        do {
            term = Math.pow(x, 2 * k + 1) / (2 * k + 1);
            if (Math.abs(term) <= eps) break;
            sum += term;
            k++;
        } while (true);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        double x = sc.nextDouble();
        double eps = sc.nextDouble();
        if (Math.abs(x) >= 1 || eps <= 0) {
            System.out.println("NaN");
            return;
        }
        System.out.println(f(x, eps));
    }
}
