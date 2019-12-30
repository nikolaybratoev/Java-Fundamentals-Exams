import java.util.Scanner;

public class DungeonDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int coins = 0;

        String[] rooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {

            String[] roomData = rooms[i].split("\\s+");
            String token = roomData[0];
            int tokenValue = Integer.parseInt(roomData[1]);

            if (token.equals("potion")) {

                if (health + tokenValue > 100) {
                    tokenValue = 100 - health;
                }

                health += tokenValue;
                System.out.printf("You healed for %d hp.%n", tokenValue);
                System.out.printf("Current health: %d hp.%n", health);

            } else if (token.equals("chest")) {

                coins += tokenValue;
                System.out.printf("You found %d coins.%n", tokenValue);

            } else {
                health -= tokenValue;

                if (health > 0) {
                    System.out.printf("You slayed %s.%n", token);
                } else {
                    System.out.printf("You died! Killed by %s.%n", token);
                    System.out.printf("Best room: %d%n", i + 1);
                    break;
                }
            }
        }

        if (health > 0) {
            System.out.printf("You've made it!%n");
            System.out.printf("Coins: %d%n", coins);
            System.out.printf("Health: %d%n", health);
        }

    }
}
