import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());

        double eggPack = flourPrice * 0.75;
        double milkPrice = flourPrice * 1.25;
        double neededMilk = milkPrice / 4;
        double cozonacPrice = eggPack + neededMilk + flourPrice;

        int coloredEggs = 0;
        int cozonacs = 0;

        while (budget >= cozonacPrice) {

            budget -= cozonacPrice;
            cozonacs++;
            coloredEggs += 3;

            if (cozonacs % 3 == 0) {
                int eggLoss = cozonacs - 2;
                coloredEggs -= eggLoss;
            }
        }

        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.",
                cozonacs,
                coloredEggs,
                budget);

    }
}
