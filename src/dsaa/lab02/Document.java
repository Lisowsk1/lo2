package dsaa.lab02;

import java.util.Scanner;

public class Document {
    public String name;
    public OneWayLinkedList<Link> links;

    public Document(String name, Scanner scan) {
        this.name = name;
        this.links = new OneWayLinkedList<>();
        load(scan);
    }

    public void load(Scanner scan) {
        while (scan.hasNextLine()) {
            String line = scan.nextLine().toLowerCase();

            if (line.equals("eod"))
                break;

            String[] word = line.split("\\s+");
            for (String s : word) {
                if (correctLink(s)) {
                    links.add(new Link(s.substring(5)));
                }
            }
        }
    }
    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)

    // ~~ there is no need to check the capital letters, because the links have to be outputted in the lowercase+numbers+_ format anyway,
    // ~~ so the line can be lowercased immediately after scanning. Also, it simplifies link checking as LiNk -> link, that is easier to implement for regex

    private static boolean correctLink(String link) {
        return link.matches("link=[a-z]+[a-z0-9_]*$");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Document: ").append(name);
        if(!links.isEmpty())
            s.append("\n");
        int newLine=0;
        for (Link link : links) {
            s.append(link.ref);
            if(newLine<links.size()-1)
                s.append("\n");
            newLine++;
        }
        return s.toString();
    }

}
