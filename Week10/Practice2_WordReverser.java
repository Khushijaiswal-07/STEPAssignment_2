
import java.util.Scanner;

public class Practice2_WordReverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.next();

        StringBuilder builder = new StringBuilder(word);
        String reversed = builder.reverse().toString();

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }

        sc.close();
    }
}
