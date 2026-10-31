
import java.util.Scanner;

public class Assignment14_QueueInOrder {

    public static int firstBreak(int[] tokens) {

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] tokens = new int[n];

        System.out.println("Enter token numbers:");
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }

        int result = firstBreak(tokens);

        System.out.println("First break index = " + result);

        if (result != -1) {
            System.out.println(tokens[result] + " comes after "
                    + tokens[result - 1]);
        } else {
            System.out.println("Queue is in order.");
        }

        sc.close();
    }
}
