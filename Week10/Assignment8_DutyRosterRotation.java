
import java.util.Arrays;
import java.util.Scanner;

public class Assignment8_DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {

        int n = names.length;
        int rotations = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + rotations) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        System.out.println("Enter the names:");

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.print("Enter number of rotations: ");
        int k = sc.nextInt();

        String[] result = rotateRoster(names, k);

        System.out.println("Rotated roster: " + Arrays.toString(result));

        sc.close();
    }
}
