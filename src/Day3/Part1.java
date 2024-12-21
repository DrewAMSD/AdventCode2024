package Day3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        Scanner s = HelperMethods.Methods.getScanner("src/Day3/input.txt");

        int total = 0;
        while (s.hasNextLine()) {
            String mem = s.nextLine();

            String patternString = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
            Pattern pattern = Pattern.compile(patternString);

            Matcher matcher = pattern.matcher(mem);

            while (matcher.find()) {
                String match = matcher.group();
                System.out.println(match);
                int comma = match.indexOf(",");
                int num1 = Integer.parseInt(match.substring(4, comma));
                int num2 = Integer.parseInt(match.substring(comma + 1, match.length() - 1));
                total += (num1 * num2);
            }
        }
        System.out.println(total);
    }
}
