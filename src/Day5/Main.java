package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<List<String>> input1 = new LinkedList<>();
    public static List<List<String>> input2 = new LinkedList<>();

    static {
        input1.add(new LinkedList<>(Arrays.asList("Z", "N")));
        input1.add(List.of(new String[]{"M", "C", "D"}));
        input1.add(List.of(new String[]{"P"}));

        input2.add(new LinkedList<>(Arrays.asList("B", "Z", "T")));
        input2.add(List.of(new String[]{"V", "H", "T", "D", "N"}));
        input2.add(List.of(new String[]{"B", "F", "M", "D"}));
        input2.add(List.of(new String[]{"T", "J", "G", "W", "V", "Q", "L"}));
        input2.add(List.of(new String[]{"W", "D", "G", "P", "V", "F", "Q", "M"}));
        input2.add(List.of(new String[]{"V", "Z", "Q", "G", "H", "F", "S"}));
        input2.add(List.of(new String[]{"Z", "S", "N", "R", "L", "T", "C", "W"}));
        input2.add(List.of(new String[]{"Z", "H", "W", "D", "J", "N", "R", "M"}));
        input2.add(List.of(new String[]{"M", "Q", "L", "F", "D", "S"}));
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/Day5/input.txt"));

        List<List<String>> input = input2;

        System.out.println(input);

        for (String line : lines) {
            System.out.println(line);
            int amount = Integer.parseInt(line.split(" ")[1]);
            int from = Integer.parseInt(line.split(" ")[3]) - 1;
            int to = Integer.parseInt(line.split(" ")[5]) - 1;

            for (int i = amount; i > 0; i--) {
                String item = input.get(from).get(input.get(from).size() - i);
                List<String> temp = new LinkedList<>(input.get(from));
                temp.remove(temp.size()-i);
                System.out.println(temp);
                input.set(from, temp);
                temp = new LinkedList<>(input.get(to));
                temp.add(item);
                input.set(to, temp);
            }

            System.out.println(input);
            System.out.println("\n\n");
        }

        System.out.println(input);

        StringBuilder erg = new StringBuilder();

        for (List<String> list : input) {
            erg.append(list.get(list.size() - 1));
        }

        System.out.println(erg);
    }
}
