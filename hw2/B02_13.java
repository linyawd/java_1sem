
package hw2;
import java.util.*;

public class B02_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short x = sc.nextShort();
        int first = -1, last = -1;
        for (int i = 0; i < 16; i++) {
            if (((x >> i) & 1) == 1) {
                if (first == -1) first = i;
                last = i;
            }
        }
        System.out.println("Перший = " + first);
        System.out.println("Останній = " + last);
    }
}
