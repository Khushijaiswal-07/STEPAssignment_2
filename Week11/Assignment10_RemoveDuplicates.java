
import java.util.Arrays;
import java.util.Scanner;

public class Assignment10_RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int unique = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[unique - 1]) {
                nums[unique] = nums[i];
                unique++;
            }
        }

        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int length = removeDuplicates(nums);

        System.out.println("Length = " + length);

        System.out.println("Unique elements: "
                + Arrays.toString(Arrays.copyOf(nums, length)));

        sc.close();
    }
}
