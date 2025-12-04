package hw11;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Scanner;


public class B11_05 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine().trim().toLowerCase();
        String url = "https://ua.sinoptik.ua/погода-" + city;
        Document doc = Jsoup.connect(url).get();

        for (int i = 0; i < 7; i++) {
            Element day = doc.select(".main").get(i);
            String date = day.select(".day-date").text() + " " + day.select(".day-month").text();
            String tMin = day.select(".min span").text();
            String tMax = day.select(".max span").text();
            System.out.println(date + " " + tMin + " " + tMax);
        }
    }
}
