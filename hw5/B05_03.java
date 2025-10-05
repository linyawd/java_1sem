package hw5;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class B05_03 {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Path in = Paths.get("/Users/lina/PycharmProjects/java_1sem/hw5/input.txt");
        Path out = Paths.get("/Users/lina/PycharmProjects/java_1sem/hw5/output.txt");

        List<String> lines = Files.readAllLines(in, StandardCharsets.UTF_8);

        int bestSegLine = -1, bestRectLine = -1, bestCircLine = -1;
        double bestSeg = -1.0, bestRectPer = -1.0, bestCircArea = Double.POSITIVE_INFINITY;

        int lineNo = 0;
        for (String line : lines) {
            lineNo++;
            if (line.trim().isEmpty()) continue;
            Scanner sc = new Scanner(line).useLocale(Locale.US);
            int type = sc.nextInt();
            if (type == 1) {
                double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();
                double len = Math.hypot(x2 - x1, y2 - y1);
                if (len > bestSeg) { bestSeg = len; bestSegLine = lineNo; }
            } else if (type == 2) {
                double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();
                double w = Math.abs(x2 - x1), h = Math.abs(y1 - y2);
                double per = 2 * (w + h);
                if (per > bestRectPer) { bestRectPer = per; bestRectLine = lineNo; }
            } else if (type == 3) {
                double xc = sc.nextDouble(), yc = sc.nextDouble(), r = sc.nextDouble();
                double area = Math.PI * r * r;
                if (area < bestCircArea) { bestCircArea = area; bestCircLine = lineNo; }
            }
            sc.close();
        }

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(out, StandardCharsets.UTF_8))) {
            pw.printf(Locale.US, "Найдовший відрізок: рядок %d, довжина = %.6f%n", bestSegLine, bestSeg);
            pw.printf(Locale.US, "Прямокутник з найбільшим периметром: рядок %d, периметр = %.6f%n", bestRectLine, bestRectPer);
            pw.printf(Locale.US, "Коло з найменшою площею: рядок %d, площа = %.6f%n", bestCircLine, bestCircArea);
        }
    }
}
