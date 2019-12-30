import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "^(?<name>[A-Za-z\\d!@#$?]+)=(?<num>[\\d]+)<<(?<code>.+)$";

        Pattern pattern = Pattern.compile(regex);

        String encrypted = "";

        while (!input.equals("Last note")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                int number = Integer.parseInt(matcher.group("num"));
                String code = matcher.group("code");

                if (number == code.length()) {

                    for (int i = 0; i < name.length(); i++) {

                        if (Character.isLetterOrDigit(name.charAt(i))) {
                            encrypted += name.charAt(i);
                        }
                    }

                    System.out.printf("Coordinates found! %s -> %s%n",
                            encrypted,
                            code);

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
