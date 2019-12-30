import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleManTTRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "([#$%*&])(?<name>[A-Za-z]+)\\1=(?<code>[0-9]+)!!(?<encrypted>...+)";

        Pattern pattern = Pattern.compile(regex);

        String encryptedMessage = "";

        while (true) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String encrypted = matcher.group("encrypted");
                int length = Integer.parseInt(matcher.group("code"));

                if (length == encrypted.length()) {

                    for (int i = 0; i < encrypted.length(); i++) {
                        char ch = (char) (encrypted.charAt(i) + length);
                        encryptedMessage += ch;
                    }

                    System.out.printf("Coordinates found! %s -> %s", name, encryptedMessage);
                    return;

                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }

            input = scanner.nextLine();

        }
    }
}
