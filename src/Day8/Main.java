package Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/Day8/input.txt"));
        int highest = 0;

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                int current = Integer.parseInt(lines.get(i).charAt(j) + "");

                int erg = checkTree(i, j, lines, current);
                highest = Math.max(erg, highest);
            }
        }

        System.out.println(highest);
    }

    public static int checkTree(int startX, int startY, List<String> input, int value) {
        int xPosVal = 0;
        int xNegVal = 0;
        int yPosVal = 0;
        int yNegVal = 0;

        for (int i = startY+1; i < input.get(startY).length(); i++) {
            yPosVal++;
            if (Integer.parseInt(input.get(startX).charAt(i) + "") >= value) {
                break;
            }
        }
        for (int i = startY-1; i > -1; i--) {
            yNegVal++;
            if (Integer.parseInt(input.get(startX).charAt(i) + "") >= value) {
                break;
            }
        }

        for (int i = startX+1; i < input.size(); i++) {
            xPosVal++;
            if (Integer.parseInt(input.get(i).charAt(startY) + "") >= value) {
                break;
            }
        }
        for (int i = startX-1; i > -1; i--) {
            xNegVal++;
            if (Integer.parseInt(input.get(i).charAt(startY) + "") >= value) {
                break;
            }
        }

        return xPosVal * xNegVal * yPosVal * yNegVal;
    }
}
