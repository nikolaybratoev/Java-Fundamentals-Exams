import java.util.Scanner;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|+");
        double budget = Double.parseDouble(scanner.nextLine());

        double profit = 0;
        double sumOfAllNewPrices = 0;

        for (int i = 0; i < input.length; i++) {

            String clothes = input[i];
            String[] token = clothes.split("->");
            String currCloth = token[0];
            double price = Double.parseDouble(token[1]);
            double newPrices = 0;

            if (currCloth.equals("Clothes")) {

                if (price <= 50.00) {

                    if (budget >= price) {
                        budget -= price;
                        double percents = price * 0.40;
                        profit += percents;
                        newPrices += percents + price;
                        sumOfAllNewPrices += newPrices;
                        System.out.printf("%.2f ", newPrices);
                    }
                }
            } else if (currCloth.equals("Shoes")) {

                if (price <= 35.00) {

                    if (budget >= price) {
                        budget -= price;
                        double percents = price * 0.40;
                        profit += percents;
                        newPrices += percents + price;
                        sumOfAllNewPrices += newPrices;
                        System.out.printf("%.2f ", newPrices);
                    }
                }
            } else {
                if (price <= 20.50) {

                    if (budget >= price) {
                        budget -= price;
                        double percents = price * 0.40;
                        profit += percents;
                        newPrices += percents + price;
                        sumOfAllNewPrices += newPrices;
                        System.out.printf("%.2f ", newPrices);
                    }
                }
            }
        }

        System.out.println();
        System.out.printf("Profit: %.2f%n", profit);

        if (sumOfAllNewPrices + budget >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }

    }
}
