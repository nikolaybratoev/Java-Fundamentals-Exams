import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Finished!")) {

            String[] commands = input.split("\\s+");
            String currentCommand = commands[0];
            String name = commands[1];

            switch (currentCommand) {

                case "Bad":
                    if (addBadKid(list, name)) continue;
                    break;

                case "Good":
                    list.remove(name);
                    break;

                case "Rename":
                    renameKid(list, commands[2], name);
                    break;

                case "Rearrange":
                    rearrangeKid(list, name);
                    break;
            }

            input = scanner.nextLine();

        }

        printList(list);

    }

    private static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {

            if (i == list.size() - 1) {
                System.out.print(list.get(i));
                break;
            }

            System.out.print(list.get(i) + ", ");
        }
    }

    private static void rearrangeKid(List<String> list, String name) {
        list.remove(name);
        list.add(name);
    }

    private static void renameKid(List<String> list, String command, String name) {
        String newName = command;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(name)) {
                list.set(i, newName);
                break;
            }
        }
    }

    private static boolean addBadKid(List<String> list, String name) {
        if (list.contains(name)) {
            return true;
        } else {
            list.add(0, name);
        }

        return false;
    }
}
