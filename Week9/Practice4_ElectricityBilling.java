import java.util.Scanner;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }

        return (100 * 5.0) + ((units - 100) * 7.0);
    }

    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        return (units * 8.0) + 100;
    }

    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }

    public String getType() {
        return "FACTORY";
    }
}

public class Practice4_ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "HOME":
                    connections[i] = new HomeConnection(units);
                    break;

                case "SHOP":
                    connections[i] = new ShopConnection(units);
                    break;

                case "FACTORY":
                    connections[i] = new FactoryConnection(units);
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Invalid connection type");
            }
        }

        for (Connection connection : connections) {
            double bill = connection.calculateBill();
            System.out.printf("%s: %.2f%n",
                    connection.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}