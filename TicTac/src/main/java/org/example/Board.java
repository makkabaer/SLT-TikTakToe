package org.example;

public class Board {
    private char[][] cells=new char[3][3];

    public Board() {
        clear(); //ordnet für alle Mitglieder der Multiarray einen Leerzeichnen
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
                cells[i][j]=' ';
            }
        }
    }

    public void makeMove(Player player) {
        // Eingabe vom Spieler entgegennehmen und auf das Board setzen
    }

    public void print() {
        System.out.println("▁▁▁▁▁▁▁");
        System.out.println("|"+cells[0][0]+"|"+cells[0][1]+"|"+cells[0][2]+"|");
        System.out.println("|"+cells[1][0]+"|"+cells[1][1]+"|"+cells[1][2]+"|");
        System.out.println("|"+cells[2][0]+"|"+cells[2][1]+"|"+cells[2][2]+"|");
        System.out.println("▔▔▔▔▔▔▔");
    }
}
