import java.util.*;

public class TheFinalQuest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = new ArrayList<>(
                Arrays.asList(scanner.nextLine().split("\\s+")));

        String line = scanner.nextLine();

        while (!"Stop".equals(line)) {

            String[] elements = line.split("\\s+");
            String type = elements[0];

            if ("Delete".equals(type)) {
                int index = Integer.parseInt(elements[1]) + 1;
                delete(words, index);
            } else if ("Swap".equals(type)) {
                String word1 = elements[1];
                String word2 = elements[2];
                swap(words, word1, word2);
            } else if ("Put".equals(type)) {
                String word = elements[1];
                int index = Integer.parseInt(elements[2]) - 1;
                put(words, word, index);
            } else if ("Sort".equals(type)) {
                sortArr(words);
            } else if ("Replace".equals(type)) {
                String word1 = elements[1];
                String word2 = elements[2];
                replaceWords(words, word1, word2);
            }

            line = scanner.nextLine();

        }

        for (String word : words) {
            System.out.print(word + " ");
        }

    }

    private static void replaceWords(List<String> words, String word1, String word2) {
        int index = words.indexOf(word2);

        if (isIndexValid(words, index)) {
            words.set(index,word1);
        }
    }

    private static void sortArr(List<String> words) {
        words.sort(Collections.reverseOrder());
    }

    private static void put(List<String> words, String word, int index) {
        if (isIndexValid(words, index) || index==words.size()) {
            words.add(index, word);
        }
    }

    private static void swap(List<String> words, String word1, String word2) {
        int word1Index = words.indexOf(word1);
        int word2Index = words.indexOf(word2);

        if (word1Index != -1 && word2Index != -1) {
            words.set(word1Index, word2);
            words.set(word2Index, word1);
        }
    }

    static void delete(List<String> word, int index) {
        if (isIndexValid(word, index)) {
            word.remove(index);
        }
    }

    static boolean isIndexValid(List<String> word, int index) {
        return index >= 0 && index < word.size();
    }
}