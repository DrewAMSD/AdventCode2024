package Day1;

import HelperMethods.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class Part1 {
    public static void main(String[] args) {
        Scanner scanner = Methods.getScanner("src/Day1/input.txt");
        if (scanner == null) {
            System.out.println("***Null Scanner***");
            return;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (scanner.hasNextInt()) {
            list1.add(scanner.nextInt());
            list2.add(scanner.nextInt());
        }

        sort(list1);
        sort(list2);

        int difference = 0;
        for (int i = 0; i < list1.size(); i++) {
            difference += Math.abs(list1.get(i)-list2.get(i));
        }
        System.out.println(difference);
    }
}
