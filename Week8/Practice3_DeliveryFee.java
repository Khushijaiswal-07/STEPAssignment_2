import java.util.Scanner;

interface Delivery {
    double calculateFee();
    String getType();
}

class StandardDelivery implements Delivery {

    private double weight;
    private double distance;

    public StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery implements Delivery {

    private double weight;
    private double distance;

    public ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery implements Delivery {

    private double weight;
    private double distance;
    private double customsFee;

    public InternationalDelivery(
            double weight,
            double distance,
            double customsFee) {

        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25
                + (2.00 * weight)
                + (0.50 * distance)
                + customsFee;
    }

    public String getType() {
        return "INTERNATIONAL";
    }
}

class DeliveryFactory {

    public static Delivery createDelivery(
            String type,
            double weight,
            double distance,
            double customsFee) {

        switch (type) {

            case "STANDARD":
                return new StandardDelivery(
                        weight, distance);

            case "EXPRESS":
                return new ExpressDelivery(
                        weight, distance);

            case "INTERNATIONAL":
                return new InternationalDelivery(
                        weight, distance, customsFee);

            default:
                throw new IllegalArgumentException(
                        "Invalid delivery type");
        }
    }
}

public class Practice3_DeliveryFee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            double customsFee = 0;

            if (type.equals("INTERNATIONAL")) {
                customsFee = sc.nextDouble();
            }

            Delivery delivery =
                    DeliveryFactory.createDelivery(
                            type,
                            weight,
                            distance,
                            customsFee);

            double fee = delivery.calculateFee();

            System.out.printf(
                    "%s: %.2f%n",
                    delivery.getType(),
                    fee);

            total = total + fee;
        }

        System.out.printf(
                "Total: %.2f%n",
                total);

        sc.close();
    }
}