import java.util.Scanner;

public class SeizeTheFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("#");

        int water = Integer.parseInt(scanner.nextLine());

        int totalFire = 0;
        double effort = 0;

        System.out.println("Cells:");

        for (int i = 0; i < input.length; i++) {

            String[] fireCell = input[i].split(" = ");
            String type = fireCell[0];
            int range = Integer.parseInt(fireCell[1]);

            switch (type) {

                case "High":
                    if (range >= 81 && range <= 125) {

                        if (water < range) {
                            continue;
                        }

                        totalFire += range;
                        water -= range;
                        effort += range * 0.25;
                        System.out.printf("- %d%n", range);
                    }else {
                        continue;
                    }
                    break;

                case "Medium":
                    if (range >= 51 && range <= 80) {

                        if (water < range) {
                            continue;
                        }

                        totalFire += range;
                        water -= range;
                        effort += range * 0.25;
                        System.out.printf("- %d%n", range);
                    }else {
                        continue;
                    }
                    break;

                case "Low":
                    if (range >= 1 && range <= 50) {

                        if (water < range) {
                            continue;
                        }

                        totalFire += range;
                        water -= range;
                        effort += range * 0.25;
                        System.out.printf("- %d%n", range);
                    }else {
                        continue;
                    }
                    break;
            }
        }

        System.out.printf("Effort: %.2f%nTotal Fire: %d",
                effort,
                totalFire);

    }
}
