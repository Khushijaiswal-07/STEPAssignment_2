import java.util.Scanner;

interface Room {
    double calculateBill();
    String getType();
}

class SingleRoom implements Room {

    private int units;

    public SingleRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom implements Room {

    private int units;
    private int occupants;

    public SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6) / (double) occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class ACRoom implements Room {

    private int units;

    public ACRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return (units * 10) + 200;
    }

    public String getType() {
        return "AC";
    }
}

class RoomFactory {

    public static Room createRoom(
            String type,
            int units,
            int occupants) {

        switch (type) {

            case "SINGLE":
                return new SingleRoom(units);

            case "SHARED":
                return new SharedRoom(
                        units, occupants);

            case "AC":
                return new ACRoom(units);

            default:
                throw new IllegalArgumentException(
                        "Invalid room type");
        }
    }
}

public class Assignment3_HostelElectricity {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            int occupants = 1;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room =
                    RoomFactory.createRoom(
                            type,
                            units,
                            occupants);

            double bill =
                    room.calculateBill();

            System.out.printf(
                    "%s: %.2f%n",
                    room.getType(),
                    bill);

            total = total + bill;
        }

        System.out.printf(
                "Total: %.2f%n",
                total);

        sc.close();
    }
}