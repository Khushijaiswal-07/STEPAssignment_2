
import java.util.HashSet;
import java.util.Scanner;

public class Assignment3_TransactionDuplicateCheck {

    public static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seen = new HashSet<>();

        for (String id : transactionIds) {
            if (seen.contains(id)) {
                return true;
            }

            seen.add(id);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        String[] ids = new String[n];

        System.out.println("Enter transaction IDs:");

        for (int i = 0; i < n; i++) {
            ids[i] = sc.next();
        }

        System.out.println("Duplicate exists: " + hasDuplicate(ids));

        sc.close();
    }
}
