
import java.util.Scanner;

public class Practice5_DigitSumReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        long number = sc.nextLong();

        long temp = number;
        long sum = 0;
        long reverse = 0;

        while (temp > 0) {
            long digit = temp % 10;

            sum += digit;
            reverse = reverse * 10 + digit;

            temp = temp / 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);

        sc.close();
    }
}
