package hw11;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class B11_01 {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.timeanddate.com/worldclock/ukraine/kyiv").get();
        String s = doc.select("span#ct").text();
        LocalTime siteTime = LocalTime.parse(s, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime local = LocalTime.now();
        System.out.println("Сайт:  " + siteTime);
        System.out.println("Локально: " + local);
        System.out.println("Різниця (сек): " + Math.abs(siteTime.toSecondOfDay() - local.toSecondOfDay()));
    }
}
