package sk.itsovy.kutka.view;

import sk.itsovy.kutka.controller.SudokuSolver;
import sk.itsovy.kutka.model.Tile;

public class Main {

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();

        sudokuSolver.start();
        printBoard(sudokuSolver.getBoard().getTiles());
        System.out.println("\n\n\n");

        while (!sudokuSolver.checkIfComplete()) {
            sudokuSolver.reduceAvailableValues();
            sudokuSolver.assignValues();
        }
        printBoard(sudokuSolver.getBoard().getTiles());

    }

    public static void printBoard(Tile[][] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            for (int j = 0; j < tiles.length; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(tiles[i][j].getValue() + " ");
            }
            System.out.println();

        }

    }
}
