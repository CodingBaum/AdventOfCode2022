package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/Day1/input.txt"));

        Set<Integer> ergs = new TreeSet<>();
        int current = 0;
        for (String line : lines) {
            if (line.equals("")) {
                ergs.add(current);
                current = 0;
            } else {
                current += Integer.parseInt(line);
            }
        }

        List<Integer> erg = new LinkedList<>(ergs);
        erg.sort(Comparator.reverseOrder());

        System.out.println(erg);

        System.out.println(erg.get(0) + erg.get(1) + erg.get(2));
    }
}
