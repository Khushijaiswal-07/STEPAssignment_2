
import java.util.Scanner;

public class Assignment6_ClassAttendanceTracker {

    public static int[] attendanceSummary(int[] days) {
        int presentDays = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int i = 0; i < days.length; i++) {

            if (days[i] == 1) {
                presentDays++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{presentDays, longestStreak};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] days = new int[n];

        System.out.println("Enter attendance (1 for Present, 0 for Absent):");

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0]
                + ", Longest streak: " + result[1]);

        sc.close();
    }
}
