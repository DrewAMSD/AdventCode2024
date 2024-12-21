package Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import HelperMethods.Pair;

public class Part2 {
    public static void main(String[] args) {
        Scanner s = HelperMethods.Methods.getScanner("src/Day3/input.txt");

        boolean canDo = true;
        int total = 0;
        while (s.hasNextLine()) {
            String mem = s.nextLine();
            List<Pair<String, Integer>> instructions = new ArrayList<>();

            String doesAndDonts = "do\\(\\)|don't\\(\\)";
            Pattern doPattern = Pattern.compile(doesAndDonts);
            Matcher doMatcher = doPattern.matcher(mem);

            while (doMatcher.find()) {
                instructions.add(new Pair<>(doMatcher.group(), doMatcher.start()));
            }

            String patternString = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(mem);

            while (matcher.find()) {
                String match = matcher.group();
                int start = matcher.start();
                int inIdx = instructions.size()-1;

                while (inIdx >= 0
                && start < instructions.get(inIdx).getValue()) {
                    inIdx--;
                }

                if (inIdx >= 0 && instructions.get(inIdx).getKey().equals("don't()")) continue;
                if (inIdx < 0 && !canDo) continue;

                int comma = match.indexOf(",");
                int num1 = Integer.parseInt(match.substring(4, comma));
                int num2 = Integer.parseInt(match.substring(comma + 1, match.length() - 1));
                total += (num1 * num2);
            }
            if (!instructions.isEmpty()) {
                canDo = instructions.getLast().getKey().equals("do()");
            }
        }
        System.out.println(total);
    }
}
