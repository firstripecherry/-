package com.company;

public class Moving {
    static int rows = -1;
    static int columns = -1;

    public Moving() {
    }

    static int[][] move(Direction d, int[][] canvas) {
        rows = canvas.length;
        columns = canvas[0].length;
        if (d.equals(Direction.UP)) {
            return moveUp(canvas);
        } else if (d.equals(Direction.DOWN)) {
            return moveDown(canvas);
        } else {
            return d.equals(Direction.RIGHT) ? moveRight(canvas) : moveLeft(canvas);
        }
    }

    static int[][] moveUp(int[][] canvas) {
        for(int i = 0; i < columns; ++i) {
            int j;
            int k;
            for(j = 0; j < rows - 1; ++j) {
                for(k = 0; k < rows - 1 - j; ++k) {
                    if (canvas[j][i] == 0) {
                        ConsoleHelper.paintCanvas(canvas);

                        for(k = j; k < rows - 1; ++k) {
                            canvas[k][i] = canvas[k + 1][i];
                        }

                        canvas[rows - 1][i] = 0;
                    }
                }
            }

            for(j = 0; j < rows - 1; ++j) {
                if (canvas[j][i] == canvas[j + 1][i]) {
                    ConsoleHelper.paintCanvas(canvas);
                    canvas[j][i] += canvas[j + 1][i];

                    for(k = j + 1; k < rows - 1; ++k) {
                        canvas[k][i] = canvas[k + 1][i];
                    }

                    canvas[rows - 1][i] = 0;
                }
            }
        }

        return canvas;
    }

    static int[][] moveDown(int[][] canvas) {
        for(int i = 0; i < columns; ++i) {
            int j;
            int k;
            for(j = rows - 1; j > 0; --j) {
                for(k = 0; k < j; ++k) {
                    if (canvas[j][i] == 0) {
                        for(k = j; k > 0; --k) {
                            canvas[k][i] = canvas[k - 1][i];
                        }

                        canvas[0][i] = 0;
                    }
                }
            }

            for(j = rows - 1; j > 0; --j) {
                if (canvas[j][i] == canvas[j - 1][i]) {
                    canvas[j][i] += canvas[j - 1][i];

                    for(k = j - 1; k > 0; --k) {
                        canvas[k][i] = canvas[k - 1][i];
                    }

                    canvas[0][i] = 0;
                }
            }
        }

        return canvas;
    }

    static int[][] moveRight(int[][] canvas) {
        for(int i = 0; i < rows; ++i) {
            int j;
            int k;
            for(j = columns - 1; j > 0; --j) {
                for(k = 0; k < j; ++k) {
                    if (canvas[i][j] == 0) {
                        for(k = j; k > 0; --k) {
                            canvas[i][k] = canvas[i][k - 1];
                        }

                        canvas[i][0] = 0;
                    }
                }
            }

            for(j = columns - 1; j > 0; --j) {
                if (canvas[i][j] == canvas[i][j - 1]) {
                    canvas[i][j] += canvas[i][j - 1];

                    for(k = j - 1; k > 0; --k) {
                        canvas[i][k] = canvas[i][k - 1];
                    }

                    canvas[i][0] = 0;
                }
            }
        }

        return canvas;
    }

    static int[][] moveLeft(int[][] canvas) {
        for(int i = 0; i < rows; ++i) {
            int j;
            int k;
            for(j = 0; j < columns - 1; ++j) {
                for(k = 0; k < columns - 1 - j; ++k) {
                    if (canvas[i][j] == 0) {
                        for(k = j; k < columns - 1; ++k) {
                            canvas[i][k] = canvas[i][k + 1];
                        }

                        canvas[i][columns - 1] = 0;
                    }
                }
            }

            for(j = 0; j < columns - 1; ++j) {
                if (canvas[i][j] == canvas[i][j + 1]) {
                    canvas[i][j] += canvas[i][j + 1];

                    for(k = j + 1; k < columns - 1; ++k) {
                        canvas[i][k] = canvas[i][k + 1];
                    }

                    canvas[i][columns - 1] = 0;
                }
            }
        }

        return canvas;
    }
}