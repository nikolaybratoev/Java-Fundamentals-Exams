import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] games = scanner.nextLine().split(", ");

        Map<String, Double> gameAndPrice = new LinkedHashMap<>();
        Map<String, String> gameWithDLC = new LinkedHashMap<>();

        for (String game : games) {

            if (game.contains("-")) {
                String[] split = game.split("-");
                String gameName = split[0];
                double gamePrice = Double.parseDouble(split[1]);

                if (!gameAndPrice.containsKey(gameName)) {
                    gameAndPrice.put(gameName, gamePrice);
                }
            } else {
                String[] split = game.split(":");
                String gameName = split[0];
                String dlcName = split[1];

                if (gameAndPrice.containsKey(gameName)) {
                    gameWithDLC.put(gameName, dlcName);
                    gameAndPrice.put(gameName, gameAndPrice.get(gameName) * 1.2);
                }
            }
        }

        for (Map.Entry<String, Double> entry : gameAndPrice.entrySet()) {

            if (gameWithDLC.containsKey(entry.getKey())) {
                gameAndPrice.put(entry.getKey(), entry.getValue() * 0.5);
            } else {
                gameAndPrice.put(entry.getKey(), entry.getValue() * 0.8);
            }
        }

        gameAndPrice.entrySet()
                .stream()
                .sorted((a, b) -> a.getValue().compareTo(b.getValue()))
                .forEach(e -> {
                    if (gameWithDLC.containsKey(e.getKey())) {
                        System.out.printf("%s - %s - %.2f%n", e.getKey(), gameWithDLC.get(e.getKey()), e.getValue());
                    }
                });

        gameAndPrice.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e ->{
                    if (!gameWithDLC.containsKey(e.getKey())) {
                        System.out.printf("%s - %.2f%n",
                                e.getKey(),
                                e.getValue());
                    }
                });
    }
}
