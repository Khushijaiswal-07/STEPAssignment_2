
import java.util.Scanner;

public class Assignment2_WarehouseBinGridScan {

    public static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int max = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int m = sc.nextInt();

        System.out.print("Enter columns: ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter grid values:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] result = warehouseSummary(grid);

        System.out.println("Total items: " + result[0]);
        System.out.println("Maximum bin coordinate: ("
                + result[1] + ", " + result[2] + ")");

        sc.close();
    }
}
