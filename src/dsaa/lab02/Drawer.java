package dsaa.lab02;

public class Drawer {
    private static void drawLine(int n, char ch) {
        for (int i = 0; i < n; i++) {
            System.out.print(ch);
        }
    }
    static void drawPyramid(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2 * (size) - 1; j++) {
                if (j < (size - i - 1) || j > (size +i - 1)) {
                    System.out.print(".");
                } else
                    System.out.print("X");
            }
            System.out.println();
        }
    }

    static void drawTreeSegment(int size, int offset) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2 * (size + offset) - 1; j++) {
                if (j < (size + offset - i - 1) || j > (size + offset + i - 1)) {
                    System.out.print(".");
                } else
                    System.out.print("X");
            }
            System.out.println();
        }
    }


    static void drawChristmasTree(int size) {
        for (int k = 1; k <= size; k++) {
            drawTreeSegment(k, size - k);
        }
    }

}