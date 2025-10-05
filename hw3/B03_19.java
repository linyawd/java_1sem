package hw3;
import java.util.*;

class Flight {
    String destination;
    String flightNumber;
    String departureTime;
    String dayOfWeek;

    Flight(String destination, String flightNumber, String departureTime, String dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    public String toString() {
        return String.format("%s  %s  %s  %s", destination, flightNumber, departureTime, dayOfWeek);
    }
}

public class B03_19 {
    static List<Flight> byDestination(List<Flight> flights, String dest) {
        List<Flight> res = new ArrayList<>();
        for (Flight f : flights) if (f.destination.equalsIgnoreCase(dest)) res.add(f);
        res.sort(Comparator.comparing(f -> f.departureTime));
        return res;
    }

    static List<Flight> byDay(List<Flight> flights, String day) {
        List<Flight> res = new ArrayList<>();
        for (Flight f : flights) if (f.dayOfWeek.equalsIgnoreCase(day)) res.add(f);
        return res;
    }

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Kyiv", "PS101", "08:30", "Monday"));
        flights.add(new Flight("Lviv", "PS202", "12:00", "Monday"));
        flights.add(new Flight("Kyiv", "PS303", "07:15", "Wednesday"));
        flights.add(new Flight("Odesa", "PS404", "09:45", "Monday"));
        flights.add(new Flight("Kyiv", "PS505", "11:10", "Monday"));

        System.out.println("Рейси до Kyiv, відсортовані за часом:");
        for (Flight f : byDestination(flights, "Kyiv")) System.out.println(f);

        System.out.println("\nРейси у понеділок:");
        for (Flight f : byDay(flights, "Monday")) System.out.println(f);
    }
}
