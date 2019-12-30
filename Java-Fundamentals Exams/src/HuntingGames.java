import java.util.Scanner;

public class HuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double energy = Double.parseDouble(scanner.nextLine());
        double waterPerPerson = Double.parseDouble(scanner.nextLine());
        double foodPerPerson = Double.parseDouble(scanner.nextLine());

        double totalFood = foodPerPerson * players * days;
        double totalWater = waterPerPerson * players * days;

        for (int day = 1; day <= days; day++) {

            double energyLoss = Double.parseDouble(scanner.nextLine());
            energy -= energyLoss;

            if (energy <= 0 ) {
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",
                        totalFood,
                        totalWater);
                return;
            }

            if (day % 2 == 0) {
                energy += energy * 0.05;
                totalWater -= totalWater * 0.30;

            }

            if (day % 3 == 0) {
                totalFood -= totalFood / players;
                energy += energy * 0.10;
            }
        }

        if (energy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energy);
        }

    }
}
