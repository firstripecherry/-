
package com.company;


public class ConsoleHelper {
    public ConsoleHelper() {
    }

    static void paintCanvas(int[][] canvas) {
        int rows = canvas.length;
        int columns = canvas[0].length;
        System.out.print(" ______ ______ ______ ");

        int i;
        for(i = 3; i < columns; ++i) {
            System.out.print("______ ");
        }

        System.out.print("\n|      |      |      |");

        for(i = 3; i < columns; ++i) {
            System.out.print("      |");
        }

        System.out.println();

        for(i = 0; i < rows; ++i) {
            int j;
            for(j = 0; j < columns; ++j) {
                if (j == 0) {
                    System.out.print("|");
                }

                if (canvas[i][j] == 0) {
                    System.out.print("      |");
                } else if (canvas[i][j] < 10) {
                    System.out.print("   " + canvas[i][j] + "  |");
                } else if (canvas[i][j] < 100) {
                    System.out.print("  " + canvas[i][j] + "  |");
                } else if (canvas[i][j] < 1000) {
                    System.out.print("  " + canvas[i][j] + " |");
                } else if (canvas[i][j] < 10000) {
                    System.out.print(" " + canvas[i][j] + " |");
                }
            }

            System.out.print("\n|______|______|______|");

            for(j = 3; j < columns; ++j) {
                System.out.print("______|");
            }

            System.out.println();
            if (i != rows - 1) {
                System.out.print("|      |      |      |");

                for(j = 3; j < columns; ++j) {
                    System.out.print("      |");
                }

                System.out.println();
            }
        }

    }
}