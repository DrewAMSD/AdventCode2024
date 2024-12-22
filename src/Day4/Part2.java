package Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
    public static int checkCurLoc(List<List<Character>> wordSearch, int r, int c) {
        char topLeft = wordSearch.get(r).get(c);
        char middle = wordSearch.get(r+1).get(c+1);
        char bottomLeft = wordSearch.get(r+2).get(c);
        char topRight = wordSearch.get(r).get(c+2);
        char bottomRight = wordSearch.get(r+2).get(c+2);
        if (middle == 'A'
        && ((topLeft == 'M' && bottomRight == 'S') || (topLeft == 'S' && bottomRight == 'M'))
        && ((bottomLeft == 'M' && topRight == 'S') || (bottomLeft == 'S' && topRight == 'M'))) {
            return 1;
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
        for (int i = 0; i < wordSearch.size()-2; i++) {
            for (int j = 0; j < wordSearch.get(i).size()-2; j++) {
                appearences += checkCurLoc(wordSearch, i, j);
            }
        }
        System.out.println(appearences);
    }
}
