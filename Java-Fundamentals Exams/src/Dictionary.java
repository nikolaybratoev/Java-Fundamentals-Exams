import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> dictionary = new TreeMap<>();

        String[] input = scanner.nextLine().split(" \\| ");

        for (int i = 0; i < input.length; i++) {

            String[] tokens = input[i].split(": ");
            String word = tokens[0];
            String definition = tokens[1];

            if (!dictionary.containsKey(word)) {
                dictionary.put(word, new ArrayList<>());
                dictionary.get(word).add(definition);
            } else {
                dictionary.get(word).add(definition);
            }
        }

        String[] wordInDictionary = scanner.nextLine().split(" \\| ");

        String option = scanner.nextLine();

        switch (option) {

            case "End":
                for (int i = 0; i < wordInDictionary.length; i++) {

                    if (dictionary.containsKey(wordInDictionary[i])) {
                        System.out.println(wordInDictionary[i]);
                        dictionary.get(wordInDictionary[i])
                                .stream()
                                .sorted((a, b) -> b.length() - a.length())
                                .forEach(e -> System.out.printf(" -%s%n", e));
                    }
                }
                break;

            case "List":
                List<String> keys = new ArrayList<>();

                dictionary.keySet()
                        .stream()
                        .forEach(e -> keys.add(e));
                System.out.println(keys.toString().replaceAll("\\[|\\]|,",""));
                break;
        }
    }
}
