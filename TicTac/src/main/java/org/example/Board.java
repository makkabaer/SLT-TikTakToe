package org.example;

public class Board {
    private char[][] cells=new char[3][3];

    public Board() {
        clear(); //ordnet für alle Mitglieder der Multiarray einen Leerzeichnen
    }

    public boolean isCellEmpty (int x, int y) {
        // if xy in cells has char -> false, return true if xy has char cell index is empty
        if (cells[x][y] == ' ') return  true;
        else return false;
    }

    public char[][] getCells() {
        return cells;
    }


    public void place (int x, int y, char marker) {
        if (isCellEmpty(x,y)) {
            cells[x][y]=marker;
            print();
        }
    }


        public boolean isFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (isCellEmpty(i,j)) return false;
                }
            }
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
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Spieler " + player.getMarker() + ", gib deine Zeile (0-2) ein: ");
            int row = scanner.nextInt();
            System.out.print("Spieler " + player.getMarker() + ", gib deine Spalte (0-2) ein: ");
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && isCellEmpty(row, col)) {
                place(row, col, player.getMarker());
                validMove = true;
            } else {
                System.out.println("Ungültiger Zug, bitte versuche es erneut.");
            }
        }
    }


    public void print() {
        System.out.println("_______");
        System.out.println("|"+cells[0][0]+"|"+cells[0][1]+"|"+cells[0][2]+"|");
        System.out.println("|"+cells[1][0]+"|"+cells[1][1]+"|"+cells[1][2]+"|");
        System.out.println("|"+cells[2][0]+"|"+cells[2][1]+"|"+cells[2][2]+"|");
        System.out.println("-------");
    }
}
