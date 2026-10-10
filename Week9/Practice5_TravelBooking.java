import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();

    public abstract String getMode();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    public double calculateBaseFare() {
        return 2500 + (distanceKm * 4.0);
    }

    public String getMode() {
        return "FLIGHT";
    }
}

public class Practice5_TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings[i] = new BusBooking(distance);
                    break;

                case "TRAIN":
                    bookings[i] = new TrainBooking(distance);
                    break;

                case "FLIGHT":
                    bookings[i] = new FlightBooking(distance);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }
        }

        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f%n",
                    booking.getMode(), booking.calculateTotal());
        }

        sc.close();
    }
}