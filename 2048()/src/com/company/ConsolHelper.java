package com.company;


import java.io.PrintStream;

public class ConsoleHelper {
    static void paintCanvas(int[][] canvas){
        /*
         ______ ______ ______ ______
        |      |      |      |      |
        |  2   |  16  | 128  | 1024 |
        |______|______|______|______|
    */
        int rows = canvas.length;
        int columns = canvas[0].length;
        Stream.out.print(" ______ ______ ______ ");
        for (int i = 3; i < columns; i++) {
            out.print("______ ");
        }
        out.print("\n|      |      |      |");
        for (int i = 3; i < columns; i++) {
            out.print("      |");
        }
        out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j==0) out.print("|");
                if (canvas[i][j]==0) out.print("      |");
                else {
                    if (canvas[i][j]<10) out.print("   " + canvas[i][j] + "  |");
                    else if (canvas[i][j]<100) out.print("  " + canvas[i][j] + "  |");
                    else if (canvas[i][j]<1000) out.print("  " + canvas[i][j] + " |");
                    else if (canvas[i][j]<10000) out.print(" " + canvas[i][j] + " |");
                }
            }
            out.print("\n|______|______|______|");
            for (int j = 3; j < columns; j++) {
                out.print("______|");
            }
            out.println();
            if (i!=rows-1) {
                out.print("|      |      |      |");
                for (int j = 3; j < columns; j++) {
                    out.print("      |");
                }
                out.println();
            }
        }
    }
}