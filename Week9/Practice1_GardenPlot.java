import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();

    public abstract String getShape();

    public String getOwner() {
        return owner;
    }
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

    public String getShape() {
        return "TRIANGLE";
    }
}

public class Practice1_GardenPlot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            switch (shape) {
                case "CIRCLE":
                    plots[i] = new CirclePlot(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    plots[i] = new RectanglePlot(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;
                case "TRIANGLE":
                    plots[i] = new TrianglePlot(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid shape");
            }
        }

        for (Plot plot : plots) {
            double area = plot.calculateArea();
            System.out.printf("%s (%s): %.2f%n",
                    plot.getOwner(), plot.getShape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}