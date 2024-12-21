package Day2;

import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        Scanner scanner = HelperMethods.Methods.getScanner("src/Day2/input.txt");

        int safeReports = 0;
        while (scanner.hasNextLine()) {
            String level = scanner.nextLine();
            Scanner lvlScanner = new Scanner(level);

            int prev = lvlScanner.nextInt();
            int cur = lvlScanner.nextInt();
            boolean increasing = prev < cur;
            boolean safe = (cur != prev && Math.abs(cur - prev) <= 3);
            while (lvlScanner.hasNextInt()) {
                prev = cur;
                cur = lvlScanner.nextInt();
                if (increasing) {
                    if (!(prev < cur && cur - prev <= 3)) {
                        safe = false;
                        break;
                    }
                } else {
                    if (!(prev > cur && prev - cur <= 3)) {
                        safe = false;
                        break;
                    }
                }
            }
            if (safe) safeReports++;
        }
        System.out.println("Safe Reports: "+safeReports);
    }
}
