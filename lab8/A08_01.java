package lab8;

import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class A08_01 {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("/Users/lina/PycharmProjects/java_1sem/lab8/input1.txt");
        Path outputPath = Paths.get("/Users/lina/PycharmProjects/java_1sem/lab8/output1.txt");

        List<String> lines = Files.readAllLines(inputPath);
        Collections.reverse(lines);
        Files.write(outputPath, lines);
    }
}
