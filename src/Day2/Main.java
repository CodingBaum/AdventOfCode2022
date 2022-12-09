package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/Day2/input.txt"));

        int erg = 0;
        for (String line :lines) {
            erg += getValue(line.charAt(2)+"");

            switch (line.charAt(2)+"") {
                case "X" -> erg += new ValueMappings(getValue(line.charAt(0)+"")).worse();
                case "Y" -> erg += new ValueMappings(getValue(line.charAt(0)+"")).getValue();
                case "Z" -> erg += new ValueMappings(getValue(line.charAt(0)+"")).better();
            }
        }

        System.out.println(erg);
    }

    public static int getValue(String s) {
        return switch (s) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            case "X" -> 0;
            case "Y" -> 3;
            case "Z" -> 6;
            default -> 0;
        };
    }
}
