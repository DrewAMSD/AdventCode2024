package Day2;

import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner scanner = HelperMethods.Methods.getScanner("src/Day2/test.txt");

        int safeReports = 0;
        while (scanner.hasNextLine()) {
            String report = scanner.nextLine();
            Scanner reportScanner = new Scanner(report);

            int prev = -1;
            int cur = -1;
            boolean increasing;
            while (reportScanner.hasNextInt()) {
                if (prev == -1) {
                    prev = reportScanner.nextInt();
                    cur = reportScanner.nextInt();
                    int third = reportScanner.nextInt();
                    if (prev < cur && cur < third && cur-prev <= 3 && third-cur <=3) {
                        increasing = true;
                    }
                    continue;
                }

                if ()
            }
            if (safe) safeReports++;
        }
        System.out.println("Safe Reports: "+safeReports);
    }
}
