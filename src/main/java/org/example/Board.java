package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        //leer
    }

    public boolean isCellEmpty (int x, int y) {
        //user story nr.1
        return true;
    }

    public void place (int x, int y, char marker) {
        if (isCellEmpty(x,y)) {
            cells[x][y]=marker;
        }
    }

    public boolean isFull() {
        //leer
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j]=0;
            }
        }
    }

    public void print() {
        //print befehl
    }
}
