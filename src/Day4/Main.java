package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/Day4/input.txt"));

        int total = 0;
        for (String line:lines) {
            int firstStart = Integer.parseInt(line.split(",")[0].split("-")[0]);
            int firstEnd = Integer.parseInt(line.split(",")[0].split("-")[1]);
            int secondStart = Integer.parseInt(line.split(",")[1].split("-")[0]);
            int secondEnd = Integer.parseInt(line.split(",")[1].split("-")[1]);

            if ((firstStart <= secondStart && firstEnd >= secondEnd) || (firstStart >= secondStart && firstEnd <= secondEnd) || (firstStart >= secondStart && firstStart <= secondEnd) || (firstEnd >= secondStart && firstEnd <= secondEnd)) {
                System.out.println(line);
                total++;
            }
        }

        System.out.println(total);
    }
}
