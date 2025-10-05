package hw3;
import java.util.*;

class Complex {
    double re, im;

    Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    Complex sub(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    Complex mul(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    Complex div(Complex c) {
        double d = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / d, (im * c.re - re * c.im) / d);
    }

    public String toString() {
        if (im == 0) return String.format("%.3f", re);
        if (re == 0) return String.format("%.3fi", im);
        if (im > 0) return String.format("%.3f + %.3fi", re, im);
        return String.format("%.3f - %.3fi", re, -im);
    }
}

public class B03_01 {
    static Complex product(Complex[] arr) {
        Complex res = new Complex(1, 0);
        for (Complex c : arr) res = res.mul(c);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        Complex[] a = new Complex[n];
        for (int i = 0; i < n; i++) {
            double re = sc.nextDouble();
            double im = sc.nextDouble();
            a[i] = new Complex(re, im);
        }
        System.out.println(product(a));
    }
}
