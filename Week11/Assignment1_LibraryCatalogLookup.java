
import java.util.Scanner;

public class Assignment1_LibraryCatalogLookup {

    public static String findBook(String[][] catalog, String targetIsbn) {

        int left = 0;
        int right = catalog.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int comparison = catalog[mid][0].compareTo(targetIsbn);

            if (comparison == 0) {
                return catalog[mid][1];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[][] catalog = new String[n][2];

        System.out.println("Enter ISBN and book title:");

        for (int i = 0; i < n; i++) {
            System.out.print("ISBN: ");
            catalog[i][0] = sc.nextLine();

            System.out.print("Title: ");
            catalog[i][1] = sc.nextLine();
        }

        System.out.print("Enter ISBN to search: ");
        String target = sc.nextLine();

        System.out.println("Book: " + findBook(catalog, target));

        sc.close();
    }
}
