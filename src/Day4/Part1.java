package Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static int step(List<List<Character>> wordSearch, String target, int x, int y, int stepX, int stepY) {
        if (target.isEmpty()) return 1;

        if (x < 0 || x >= wordSearch.size()
                || y < 0 || y >= wordSearch.get(x).size()) {
            return 0;
        }

        if (target.charAt(0) == wordSearch.get(x).get(y)) {
            return step(wordSearch, target.substring(1), x+stepX, y+stepY, stepX, stepY);
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner input = HelperMethods.Methods.getScanner("src/Day4/input.txt");

        List<List<Character>> wordSearch = new ArrayList<>();
        while (input.hasNextLine()) {
            String inputRow = input.nextLine();
            List<Character> row = new ArrayList<>();
            for (int i = 0; i < inputRow.length(); i++) {
                row.add(inputRow.charAt(i));
            }
            wordSearch.add(row);
        }

        int appearences = 0;
        for (int i = 0; i < wordSearch.size(); i++) {
            for (int j = 0; j < wordSearch.get(i).size(); j++) {
                // up and down
                appearences += step(wordSearch, "XMAS", i, j, 1, 0);
                appearences += step(wordSearch, "XMAS", i, j, -1, 0);
                // left and right
                appearences += step(wordSearch, "XMAS", i, j, 0, 1);
                appearences += step(wordSearch, "XMAS", i, j, 0, -1);
                // top left to bottom right
                appearences += step(wordSearch, "XMAS", i, j, 1, 1);
                appearences += step(wordSearch, "XMAS", i, j, -1, -1);
                // bottom left to top right
                appearences += step(wordSearch, "XMAS", i, j, 1, -1);
                appearences += step(wordSearch, "XMAS", i, j, -1, 1);
            }
        }
        System.out.println(appearences);
    }
}
