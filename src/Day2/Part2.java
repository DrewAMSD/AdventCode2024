package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner scanner = HelperMethods.Methods.getScanner("src/Day2/input.txt");

        int safeReports = 0;
        while (scanner.hasNextLine()) {
            String report = scanner.nextLine();
            Scanner reportScanner = new Scanner(report);

            List<Integer> levels = new ArrayList<>();
            while (reportScanner.hasNextInt()) {
                levels.add(reportScanner.nextInt());
            }

            boolean safe = getReportSafety(levels);
            for (int i = 0; i < levels.size(); i++) {
                int level = levels.get(i);
                levels.remove(i);
                boolean safeReport = getReportSafety(levels);
                if (safeReport) {
                    safe = true;
                    break;
                }
                levels.add(i, level);
            }
            if (safe) safeReports++;
        }
        System.out.println(safeReports);
    }

    public static boolean getReportSafety(List<Integer> report) {
        for (int i = 0; i < report.size()-1; i++) {
            int num1 = report.get(i);
            int num2 = report.get(i+1);
            if (Math.abs(num1-num2) < 1 || Math.abs(num1-num2) > 3) {
                return false;
            }
            if (i == 0) continue;
            if (num1 < num2 && report.get(i-1) < num1) continue;
            if (num1 > num2 && report.get(i-1) > num1) continue;
            return false;
        }
        return true;
    }
}
