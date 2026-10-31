
import java.util.Scanner;
import java.util.Arrays;

public class Assignment15_DiceThrowTally {

    public static int[] diceSort(int[] rolls) {

        int[] count = new int[7];

        // Count occurrences of each dice value
        for (int i = 0; i < rolls.length; i++) {
            count[rolls[i]]++;
        }

        // Print counts
        System.out.print("Counts: ");

        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + " ");
        }

        System.out.println();

        // Create sorted array
        int[] result = new int[rolls.length];
        int index = 0;

        for (int v = 1; v <= 6; v++) {
            for (int j = 0; j < count[v]; j++) {
                result[index] = v;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of dice throws: ");
        int n = sc.nextInt();

        int[] rolls = new int[n];

        System.out.println("Enter dice results (1 to 6):");
        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();

            if (rolls[i] < 1 || rolls[i] > 6) {
                System.out.println("Invalid dice value. Enter 1 to 6.");
                sc.close();
                return;
            }
        }

        int[] sorted = diceSort(rolls);

        System.out.println("Sorted: " + Arrays.toString(sorted));

        sc.close();
    }
}
