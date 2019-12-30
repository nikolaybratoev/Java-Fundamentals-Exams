import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> journal = Arrays.stream(scanner.nextLine()
                .split(", "))
                .collect(Collectors.toCollection(ArrayList::new));

        String input = scanner.nextLine();

        while (!input.equals("Retire!")) {

            String[] token = input.split(" - ");
            String command = token[0];

            switch (command) {

                case "Start":
                    if (!journal.contains(token[1])) {
                        journal.add(token[1]);
                    }
                    break;

                case "Complete":
                    journal.remove(token[1]);
                    break;

                case "Side Quest":
                    String[] questData = token[1].split(":");
                    String questName = questData[0];
                    String sideQuest = questData[1];

                    int index = journal.indexOf(questName);

                    if (index != -1 && !journal.contains(sideQuest)) {
                        journal.add(index + 1, sideQuest);
                    }
                    break;

                case "Renew":
                    if (journal.contains(token[1])) {
                        journal.remove(token[1]);
                        journal.add(token[1]);
                    }
                    break;
            }

            input = scanner.nextLine();

        }

        for (int i = 0; i < journal.size(); i++) {
            if (i == journal.size() - 1) {
                System.out.println(journal.get(i));
            }else {
                System.out.print(journal.get(i) + ", ");
            }
        }

    }
}
