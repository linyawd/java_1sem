package hw2;
import java.util.*;

public class B02_01 {
    static double min(double[] a) {
        double m = a[0];
        for (int i = 1; i < a.length; i++) if (a[i] < m) m = a[i];
        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextDouble();
        System.out.println(min(a));
    }
}
