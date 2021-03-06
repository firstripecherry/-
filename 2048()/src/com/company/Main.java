package com.company;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        while(true) {
            System.out.println("Enter the number of columns.");

            while(!keyboardObserver.hasKeyEvents()) {
            }

            KeyEvent event = keyboardObserver.getEventFromTop();
            int column = event.getKeyCode();
            if (column > 98 && column < 102 || column > 50 && column < 54) {
                while(true) {
                    System.out.println("Enter the number of rows.");

                    while(!keyboardObserver.hasKeyEvents()) {
                    }

                    event = keyboardObserver.getEventFromTop();
                    int row = event.getKeyCode();
                    if (row > 98 && row < 102 || row > 50 && row < 54) {
                        int[][] canvas = GameLogic.createNewCanvas(row - 96 > 0 ? row - 96 : row - 48, column - 96 > 0 ? column - 96 : column - 48);

                        while(true) {
                            ConsoleHelper.paintCanvas(canvas);
                            if (GameLogic.isGameOver(canvas)) {
                                System.out.println("Game over");
                                return;
                            }

                            int[][] tmpArray = GameLogic.copy2DArray(canvas);

                            Direction d;
                            do {
                                d = null;

                                do {
                                    while(!keyboardObserver.hasKeyEvents()) {
                                    }

                                    KeyEvent event;
                                    event = keyboardObserver.getEventFromTop();
                                    if (event.getKeyCode() == 37) {
                                        d = Direction.LEFT;
                                    } else if (event.getKeyCode() == 38) {
                                        d = Direction.UP;
                                    } else if (event.getKeyCode() == 40) {
                                        d = Direction.DOWN;
                                    } else if (event.getKeyCode() == 39) {
                                        d = Direction.RIGHT;
                                    }
                                } while(d == null);

                                Moving.move(d, canvas);
                            } while(!GameLogic.isCanged(tmpArray, canvas));

                            GameLogic.randomSquare(d, canvas);
                        }
                    }

                    System.out.println("It should be 3, 4 or 5");
                }
            }

            System.out.println("It should be 3, 4 or 5");
        }
    }
}
