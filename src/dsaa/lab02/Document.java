package dsaa.lab02;

import java.util.Scanner;

public class Document {
    public static void loadDocument(String name, Scanner scan) {
        while(scan.hasNextLine()) {
            String line = scan.nextLine().toLowerCase();

            if(line.equals("eod"))
                break;

            String word[] = line.split(" ");
            for (int i = 0; i < word.length; i++) {
                if(correctLink(word[i]))
                    System.out.println(word[i].substring(5));
            }
        }
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    public static boolean correctLink(String link) {
        return link.matches("link=[a-z]+[a-z0-9_]*$");
    }
}