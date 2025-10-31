package hw6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_01 {
    public static void main(String[] args) {
        String text = "Дата підпису: 12.05.2022 або __.__.____ повинна бути оновлена.";
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String currentDate = today.format(formatter);
        String regex = "\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b|__\\.\\.____";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        String result = matcher.replaceAll(currentDate);

        System.out.println(result);
    }
}