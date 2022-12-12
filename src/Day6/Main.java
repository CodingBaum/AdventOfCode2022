package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/Day6/input.txt"));
        String input = lines.get(0);

        String[] list = new String[14];
        for (int i = 0; i < input.length(); i++) {
            if (i < 14) {
                list[i] = input.charAt(i) + "";
            } else {
                boolean yes = true;
                for (String s : list) {
                    if (Arrays.stream(list).filter(x -> x.equals(s)).collect(Collectors.toList()).size() > 1) {
                        yes = false;
                    }
                }
                if (yes) {
                    System.out.println(i + " | " + Arrays.toString(list));
                    break;
                }
                for (int j = 0; j < 13; j++) {
                    list[j] = list[j+1];
                }
                list[13] = input.charAt(i)+"";
            }
        }
    }
}
