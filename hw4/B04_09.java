package hw4;
import java.util.*;

abstract class Car {
    String model;
    double price;
    int vMin, vMax;
    double base; // л/100км при крейсері

    Car(String model, double price, int vMin, int vMax, double base) {
        this.model = model;
        this.price = price;
        this.vMin = vMin;
        this.vMax = vMax;
        this.base = base;
    }

    abstract double fuelAt(int v);

    boolean inSpeedRange(int lo, int hi) {
        return vMax >= lo && vMin <= hi;
    }

    public String toString() {
        return model + " $" + String.format(Locale.US,"%.0f",price) +
               " [" + vMin + "-" + vMax + "] " + String.format(Locale.US,"%.1f",base) + "L/100";
    }
}

class Economy extends Car {
    Economy(String m,double p,int vMin,int vMax,double b){ super(m,p,vMin,vMax,b); }
    double fuelAt(int v){
        if (v < vMin) v = vMin; if (v > vMax) v = vMax;
        double k = 1.0 + Math.max(0, v - 60) * 0.008 - Math.max(0, 60 - v) * 0.004;
        return base * k;
    }
}

class Comfort extends Car {
    Comfort(String m,double p,int vMin,int vMax,double b){ super(m,p,vMin,vMax,b); }
    double fuelAt(int v){
        if (v < vMin) v = vMin; if (v > vMax) v = vMax;
        double k = 1.0 + Math.max(0, v - 55) * 0.010 - Math.max(0, 55 - v) * 0.003;
        return base * k;
    }
}

class SUV extends Car {
    SUV(String m,double p,int vMin,int vMax,double b){ super(m,p,vMin,vMax,b); }
    double fuelAt(int v){
        if (v < vMin) v = vMin; if (v > vMax) v = vMax;
        double k = 1.0 + Math.max(0, v - 50) * 0.014 - Math.max(0, 50 - v) * 0.002;
        return base * k;
    }
}

class TaxiPark {
    Car[] cars;
    TaxiPark(Car[] cars){ this.cars = cars; }

    double totalPrice(){
        double s = 0;
        for (Car c : cars) s += c.price;
        return s;
    }

    Car[] sortByFuelAt(int v){
        Car[] b = cars.clone();
        Arrays.sort(b, Comparator.comparingDouble(c -> c.fuelAt(v)));
        return b;
    }

    Car[] findBySpeedRange(int lo,int hi){
        ArrayList<Car> r = new ArrayList<>();
        for (Car c : cars) if (c.inSpeedRange(lo,hi)) r.add(c);
        return r.toArray(new Car[0]);
    }
}

public class B04_09 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Car[] fleet = {
            new Economy("Skoda Rapid",   12500, 40, 170, 5.8),
            new Comfort("Toyota Corolla",17000, 40, 180, 6.6),
            new SUV    ("Hyundai Tucson",26000, 45, 190, 8.8),
            new Economy("Renault Logan", 11000, 40, 165, 6.0),
            new Comfort("VW Jetta",      21000, 40, 200, 7.2)
        };

        TaxiPark tp = new TaxiPark(fleet);

        System.out.println("Вартість автопарку: $" + String.format("%.0f", tp.totalPrice()));

        int speed = 90;
        System.out.println("\nСортування за розходом пального при " + speed + " км/год:");
        for (Car c : tp.sortByFuelAt(speed))
            System.out.println(c.model + " -> " + String.format(Locale.US,"%.2f", c.fuelAt(speed)) + " L/100");

        int lo = 90, hi = 140;
        System.out.println("\nАвто з діапазоном швидкостей, що перетинає [" + lo + ";" + hi + "]:");
        for (Car c : tp.findBySpeedRange(lo, hi)) System.out.println(c);
    }
}
