package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/Day3/input.txt"));

        int total = 0;
        for (int i = 0; i < lines.size(); i+=3) {
            String sack1 = lines.get(i);
            String sack2 = lines.get(i+1);
            String sack3 = lines.get(i+2);

            for (int j = 0; j < sack1.length(); j++) {
                if (sack2.contains(sack1.charAt(j)+"") && sack3.contains(sack1.charAt(j)+"")) {
                    total += getCharValue(sack1.charAt(j)+"");
                    break;
                }
            }
        }
        System.out.println(total);
    }

    public static int getCharValue(String s) {
        return s.toLowerCase().equals(s) ? s.charAt(0) -96 : s.charAt(0) - 38;
    }
}
