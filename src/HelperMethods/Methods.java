package HelperMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Methods {
    public static Scanner getScanner(String fileLocation) {
        try {
            File input = new File(fileLocation);
            Scanner scanner = new Scanner(input);
            return scanner;
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
