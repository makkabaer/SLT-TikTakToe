package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    protected Board board;

    public TicTacToe() {
        //TicTacToe
    }

    public void start() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;

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


    /*public? protected? oder package protected? */ void switchCurrentPlayer() {
        //X auf O, oder O auf X zu switchen
    }

    /*wieder dasselbe Problem*/ boolean hasWinner() {
        // if (dreiInSelbenZeile/Spalte/Diagonal)
        return true;
        //else return false;
    }

}
