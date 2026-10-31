
import java.util.Scanner;
import java.util.Arrays;

public class Assignment4_ExamScoreBandCounter {

    // Finds the first position where the value is >= target
    public static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Finds the first position where the value is > target
    public static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        int first = lowerBound(scores, low);
        int last = upperBound(scores, high);

        return last - first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores in ascending order:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter low score: ");
        int low = sc.nextInt();

        System.out.print("Enter high score: ");
        int high = sc.nextInt();

        int result = countInBand(scores, low, high);

        System.out.println("Students in score band: " + result);

        sc.close();
    }
}
