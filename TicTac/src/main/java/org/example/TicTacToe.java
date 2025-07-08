package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    protected Board board;

    public TicTacToe() {
        board = new Board();
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
    }

    public void start() {


        boolean playAgain;

        do {
            board.print();
            while (!board.isFull() && !hasWinner()) {
                board.makeMove(currentPlayer);
                if (hasWinner()) {
                    System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
                    break;
                }
                switchCurrentPlayer();
            }

            if (!hasWinner()) {
                System.out.println("Unentschieden!");
            }

            // Eingabe für neue Runde
            System.out.print("Möchtest du nochmal spielen? (j/n): ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("j");

            if (playAgain) {
                board = new Board(); // neues Board erzeugen
                currentPlayer = player1; // wieder mit Spieler 1 starten
            }

        } while (playAgain);
    }


    void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() { //nur für die Testing
        return currentPlayer;
    }

    boolean hasWinner() {

        char[][] cells = board.getCells(); // du brauchst diese Getter in Board.java

        // Reihen prüfen
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != ' ' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                return true;
            }
        }

        // Spalten prüfen
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] != ' ' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                return true;
            }
        }

        // Diagonalen prüfen
        if (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return true;
        }
        if (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return true;
        }

        return false;
    }
}
