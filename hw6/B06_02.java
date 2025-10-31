package hw6;

import java.util.regex.*;
import java.util.*;

public class B06_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) sb.append(sc.nextLine()).append(System.lineSeparator());
        String text = sb.toString();

        String regex = "(\\+?\\d{1,3}[- ]?)?(\\(?\\d{2,3}\\)?[- ]?)?\\d{2,3}[- ]?\\d{2}[- ]?\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
