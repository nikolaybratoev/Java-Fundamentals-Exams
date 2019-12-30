import java.util.Scanner;

public class ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = Integer.parseInt(scanner.nextLine());
        int daysLeft = Integer.parseInt(scanner.nextLine());

        int ornament = 2;
        int skirt = 5;
        int garlands = 3;
        int lights = 15;

        int spirit = 0;
        int sum = 0;

        for (int day = 1; day <= daysLeft; day++) {

            if (day % 11 == 0) {
                quantity += 2;
            }

            if (day % 2 == 0) {
                sum += quantity * ornament;
                spirit += 5;
            }

            if (day % 3 == 0) {
                sum += skirt * quantity;
                sum += garlands * quantity;
                spirit += 13;
            }

            if (day % 5 == 0) {
                sum += lights * quantity;
                spirit += 17;

                if (day % 3 == 0) {
                    spirit += 30;
                }

            }

            if (day % 10 == 0) {

                if (day == 10 && daysLeft % 10 == 0) {
                    spirit -= 30;
                }

                spirit -= 20;
                sum += skirt + garlands + lights;
            }
        }

        System.out.printf("Total cost: %d%nTotal spirit: %d",
                sum,
                spirit);

    }
}
