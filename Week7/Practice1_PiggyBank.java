class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings = savings + amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit rejected");
        }
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
        } else if (amount <= 0) {
            System.out.println("Withdrawal rejected");
        } else {
            savings = savings - amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public double getSavings() {
        return savings;
    }
}

public class Practice1_PiggyBank {
    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}