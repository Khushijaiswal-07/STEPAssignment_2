import java.time.LocalDate;
import java.util.Scanner;

interface LibraryItem {
    LocalDate calculateDueDate();
    String getTitle();
}

class Book implements LibraryItem {

    private String title;
    private LocalDate currentDate;

    public Book(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {

    private String title;
    private LocalDate currentDate;

    public DVD(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {

    private String title;
    private LocalDate currentDate;

    public Magazine(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

class LibraryItemFactory {

    public static LibraryItem createItem(
            String type, String title, LocalDate currentDate) {

        switch (type) {

            case "BOOK":
                return new Book(title, currentDate);

            case "DVD":
                return new DVD(title, currentDate);

            case "MAGAZINE":
                return new Magazine(title, currentDate);

            default:
                throw new IllegalArgumentException(
                        "Invalid item type");
        }
    }
}

public class Practice2_LibraryDueDate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalDate currentDate =
                LocalDate.of(2023, 10, 26);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int firstSpace = line.indexOf(" ");

            String type = line.substring(0, firstSpace);

            String title =
                    line.substring(firstSpace + 1);

            if (title.startsWith("\"") &&
                    title.endsWith("\"")) {

                title = title.substring(
                        1, title.length() - 1);
            }

            LibraryItem item =
                    LibraryItemFactory.createItem(
                            type, title, currentDate);

            System.out.println(
                    item.getTitle() + ": " +
                    item.calculateDueDate());
        }

        sc.close();
    }
}