import java.util.Scanner;

interface Vehicle {
    double calculateCharge();
    String getType();
}

class Bike implements Vehicle {

    private int hours;

    public Bike(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return hours * 10;
    }

    public String getType() {
        return "BIKE";
    }
}

class Car implements Vehicle {

    private int hours;

    public Car(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {

        if (hours == 1) {
            return 30;
        }

        return 30 + ((hours - 1) * 20);
    }

    public String getType() {
        return "CAR";
    }
}

class Truck implements Vehicle {

    private int hours;

    public Truck(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {

        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    public String getType() {
        return "TRUCK";
    }
}

class VehicleFactory {

    public static Vehicle createVehicle(
            String type, int hours) {

        switch (type) {

            case "BIKE":
                return new Bike(hours);

            case "CAR":
                return new Car(hours);

            case "TRUCK":
                return new Truck(hours);

            default:
                throw new IllegalArgumentException(
                        "Invalid vehicle type");
        }
    }
}

public class Assignment2_ParkingCharge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle =
                    VehicleFactory.createVehicle(
                            type, hours);

            double charge =
                    vehicle.calculateCharge();

            System.out.printf(
                    "%s: %.2f%n",
                    vehicle.getType(),
                    charge);

            total = total + charge;
        }

        System.out.printf(
                "Total: %.2f%n",
                total);

        sc.close();
    }
}