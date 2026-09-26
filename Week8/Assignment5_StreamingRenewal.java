import java.time.LocalDate;
import java.util.Scanner;

interface SubscriptionPlan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class BasicPlan implements SubscriptionPlan {

    public LocalDate calculateRenewalDate(
            LocalDate startDate) {

        return startDate.plusDays(30);
    }
}

class StandardPlan implements SubscriptionPlan {

    public LocalDate calculateRenewalDate(
            LocalDate startDate) {

        return startDate.plusDays(90);
    }
}

class PremiumPlan implements SubscriptionPlan {

    public LocalDate calculateRenewalDate(
            LocalDate startDate) {

        return startDate.plusDays(365);
    }
}

class PlanFactory {

    public static SubscriptionPlan createPlan(
            String type) {

        switch (type) {

            case "BASIC":
                return new BasicPlan();

            case "STANDARD":
                return new StandardPlan();

            case "PREMIUM":
                return new PremiumPlan();

            default:
                throw new IllegalArgumentException(
                        "Invalid plan type");
        }
    }
}

public class Assignment5_StreamingRenewal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate =
                    LocalDate.parse(date);

            SubscriptionPlan plan =
                    PlanFactory.createPlan(type);

            LocalDate renewalDate =
                    plan.calculateRenewalDate(
                            startDate);

            System.out.println(
                    name + ": " + renewalDate);
        }

        sc.close();
    }
}