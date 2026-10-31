
import java.util.Scanner;

public class Assignment6_BestSingleTradeProfit {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            int profit = price - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("Maximum profit: " + maxProfit(prices));

        sc.close();
    }
}
