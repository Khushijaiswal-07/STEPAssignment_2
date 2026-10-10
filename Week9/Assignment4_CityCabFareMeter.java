
import java.util.Scanner;

abstract class Cab {
    protected double distance;

    private static final double MINIMUM_FARE = 100.0;

    public Cab(double distance) {
        this.distance = distance;
    }

    protected abstract double calculateDistanceFare();

    public abstract String getType();

    public double calculateFare(boolean night) {
        double fare = Math.max(calculateDistanceFare(), MINIMUM_FARE);

        if (night && this instanceof NightService) {
            fare *= 1.20;
        }

        return fare;
    }

    public boolean supportsNightService() {
        return this instanceof NightService;
    }
}

interface NightService {
}

class MiniCab extends Cab {
    public MiniCab(double distance) {
        super(distance);
    }

    @Override
    protected double calculateDistanceFare() {
        return distance * 10.0;
    }

    @Override
    public String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double distance) {
        super(distance);
    }

    @Override
    protected double calculateDistanceFare() {
        return distance * 14.0;
    }

    @Override
    public String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double distance) {
        super(distance);
    }

    @Override
    protected double calculateDistanceFare() {
        return distance * 18.0;
    }

    @Override
    public String getType() {
        return "SUV";
    }
}

public class Assignment4_CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            boolean night = time.equals("NIGHT");
            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    System.out.println("Invalid cab type: " + type);
                    continue;
            }

            if (night && !cab.supportsNightService()) {
                System.out.println(cab.getType()
                        + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(night);

            System.out.printf("%s: %.2f%n",
                    cab.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
