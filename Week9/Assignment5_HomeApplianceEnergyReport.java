
import java.util.Scanner;

abstract class Appliance {
    protected double hours;

    private static final double COST_PER_UNIT = 8.0;

    public Appliance(double hours) {
        this.hours = hours;
    }

    protected abstract double getPowerRating();

    public abstract String getName();

    public double calculateUnits(boolean saver) {
        double units = getPowerRating() * hours / 1000.0;

        if (saver && this instanceof SaverMode) {
            units *= 0.75;
        }

        return units;
    }

    public double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }

    public boolean supportsSaverMode() {
        return this instanceof SaverMode;
    }
}

interface SaverMode {
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerRating() {
        return 150.0;
    }

    @Override
    public String getName() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerRating() {
        return 1500.0;
    }

    @Override
    public String getName() {
        return "AC";
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerRating() {
        return 100.0;
    }

    @Override
    public String getName() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerRating() {
        return 500.0;
    }

    @Override
    public String getName() {
        return "WASHER";
    }
}

public class Assignment5_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");

            String type = parts[0].toUpperCase();
            double hours = Double.parseDouble(parts[1]);

            boolean saver = parts.length > 2
                    && parts[2].equalsIgnoreCase("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    System.out.println("Invalid appliance: " + type);
                    continue;
            }

            if (saver && !appliance.supportsSaverMode()) {
                System.out.println(appliance.getName()
                        + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(saver);
            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getName(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
