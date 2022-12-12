package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/Day7/input.txt"));
        List<String> paths = new LinkedList<>();
        Map<String, Integer> sizes = new TreeMap<>();

        for (String line :lines) {
            if (line.startsWith("$ ")) {
                String cmd = line.split(" ")[1];
                String param = null;
                if (!cmd.equals("ls")) {
                    param = line.split(" ")[2];
                }

                switch (cmd) {
                    case "cd" -> {
                        if (param.equals("..")) {
                            paths.remove(paths.size()-1);
                        } else if (param.equals("/")) {
                            paths = new LinkedList<>();
                            paths.add("/");
                        } else {
                            paths.add(param);
                        }
                    }
                }
            } else {
                if (line.startsWith("dir")) {
                    continue;
                } else {
                    String path = "";
                    for (int i = 0; i < paths.size(); i++) {
                        path += paths.get(i);
                        sizes.put(path, sizes.getOrDefault(path, 0)+Integer.parseInt(line.split(" ")[0]));
                    }
                }
            }
        }

        int total = 70000000;
        int min = 30000000;
        int free = total - sizes.get("/");
        int required = min - free;

        System.out.println(required);

        Set<Integer> temp = new TreeSet<>();

        for (int i :sizes.values()) {
            if (i > required) {
                temp.add(i);
            }
        }

        System.out.println(temp.stream().findFirst());
    }
}
