import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> bandTime = new LinkedHashMap<>();
        Map<String, List<String>> bandMembers = new HashMap<>();

        int totalTime = 0;

        while (!input.equals("start of concert")) {

            String[] tokens = input.split("; ");
            String command = tokens[0];
            String name = tokens[1];

            if (command.equals("Play")) {

                int time = Integer.parseInt(tokens[2]);
                totalTime += time;

                if (!bandTime.containsKey(name)) {
                    bandTime.put(name, time);
                } else {
                    bandTime.put(name, bandTime.get(name) + time);
                }

            } else {
                String[] members = tokens[2].split(", ");

                if (!bandMembers.containsKey(name)) {
                    bandMembers.put(name, new ArrayList<>());

                    for (String member : members) {
                        if (!bandMembers.get(name).contains(member)) {
                            bandMembers.get(name).add(member);
                        }
                    }
                } else {
                    for (String member : members) {
                        if (!bandMembers.get(name).contains(member)) {
                            bandMembers.get(name).add(member);
                        }
                    }
                }
            }

            input = scanner.nextLine();

        }

        System.out.println("Total time: " + totalTime);

        bandTime.entrySet()
                .stream()
                .sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        })
                .forEach(e -> System.out.printf("%s -> %d%n",
                        e.getKey(),
                        e.getValue()));

        String band = scanner.nextLine();

        System.out.println(band);

        for (String member : bandMembers.get(band)) {
            System.out.printf("=> %s%n",
                    member);
        }

    }
}
