
import java.util.HashMap;
import java.util.Scanner;

public class Assignment4_EmployeeIDLookup {

    public static HashMap<String, String> buildLookup(String[][] records) {
        HashMap<String, String> lookup = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            lookup.put(records[i][0], records[i][1]);
        }

        return lookup;
    }

    public static String getDepartment(
            HashMap<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        String[][] records = new String[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee ID: ");
            records[i][0] = sc.next();

            System.out.print("Enter department: ");
            records[i][1] = sc.next();
        }

        HashMap<String, String> lookup = buildLookup(records);

        System.out.print("Enter employee ID to search: ");
        String id = sc.next();

        System.out.println("Department: " + getDepartment(lookup, id));

        sc.close();
    }
}
