
import java.util.Scanner;

abstract class Student {
    protected String name;

    private static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateTuition();

    public abstract boolean usesBus();

    public double calculateTotalFee() {
        double total = calculateTuition();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }

    public String getName() {
        return name;
    }
}

class DayScholar extends Student {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }

    @Override
    public boolean usesBus() {
        return false;
    }
}

class ScholarshipStudent extends Student {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

public class Assignment3_CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    System.out.println("Invalid student type: " + type);
                    continue;
            }

            double fee = student.calculateTotalFee();

            System.out.printf("%s: %.2f%n",
                    student.getName(), fee);

            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
