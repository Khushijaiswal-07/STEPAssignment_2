import java.util.Scanner;

interface Customer {
    double calculateFinalAmount(double amount);
    String getType();
}

class StudentCustomer implements Customer {

    public double calculateFinalAmount(double amount) {
        return amount - (amount * 0.10);
    }

    public String getType() {
        return "STUDENT";
    }
}

class StaffCustomer implements Customer {

    public double calculateFinalAmount(double amount) {
        return amount - (amount * 0.05);
    }

    public String getType() {
        return "STAFF";
    }
}

class GuestCustomer implements Customer {

    public double calculateFinalAmount(double amount) {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

class CustomerFactory {

    public static Customer createCustomer(String type) {

        switch (type) {

            case "STUDENT":
                return new StudentCustomer();

            case "STAFF":
                return new StaffCustomer();

            case "GUEST":
                return new GuestCustomer();

            default:
                throw new IllegalArgumentException(
                        "Invalid customer type");
        }
    }
}

public class Assignment1_CanteenBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer =
                    CustomerFactory.createCustomer(type);

            double finalAmount =
                    customer.calculateFinalAmount(amount);

            System.out.printf(
                    "%s: %.2f%n",
                    customer.getType(),
                    finalAmount);

            total = total + finalAmount;
        }

        System.out.printf(
                "Total: %.2f%n",
                total);

        sc.close();
    }
}