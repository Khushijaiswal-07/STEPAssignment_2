
import java.util.Scanner;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    public Ticket(int count) {
        this.count = count;
    }

    protected abstract double getPricePerTicket();

    public abstract String getSeatType();

    public double calculateAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 150.0;
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 250.0;
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 400.0;
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }
}

public class Assignment1_MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
                default:
                    System.out.println("Invalid seat type: " + seat);
                    continue;
            }

            double amount = ticket.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    ticket.getSeatType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
