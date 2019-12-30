import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> gifts = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("No Money")) {

            String[] tokens = command.split("\\s+");
            String currCommand = tokens[0];
            String gift = tokens[1];

            switch (currCommand) {

                case "OutOfStock":
                    for (int currGift = 0; currGift < gifts.size(); currGift++) {
                        if (gifts.get(currGift).equals(gift)) {
                            gifts.set(currGift, "None");
                        }
                    }
                    break;

                case "Required":
                    int index = Integer.parseInt(tokens[2]);

                    if (index >= 0 && index < gifts.size()) {
                        gifts.set(index, gift);
                    }
                    break;

                case "JustInCase":
                    for (int i = 0; i < gifts.size(); i++) {
                        if (i == gifts.size() - 1) {
                            gifts.set(i, gift);
                        }
                    }
                    break;
            }

            command = scanner.nextLine();

        }

        for (String gift : gifts) {
            if (gift.equals("None")) {
                continue;
            }

            System.out.print(gift + " ");
        }

    }
}
