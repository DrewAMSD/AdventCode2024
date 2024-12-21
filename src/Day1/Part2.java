package Day1;

import java.util.*;

public class Part2 {
    public static void main(String[] args) {
        Scanner scanner = HelperMethods.Methods.getScanner("src/Day1/input.txt");
        if (scanner == null) {
            System.out.println("Null Scanner");
            return;
        }

        Set<Integer> set = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();

        while (scanner.hasNextInt()) {
            set.add(scanner.nextInt());

            int num = scanner.nextInt();
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        int similarityScore = 0;
        for (int num : set) {
            if (!map.containsKey(num)) continue;
            similarityScore += (num * map.get(num));
        }

        System.out.println(similarityScore);
    }
}
