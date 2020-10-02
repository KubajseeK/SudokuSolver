package sk.itsovy.kutka.controller;

import sk.itsovy.kutka.Input;
import sk.itsovy.kutka.model.Board;

public class SudokuSolver {
    private int[][] array;
    private Board board;

    public Board getBoard() {
        return board;
    }

    public void start() {
        if (!readData()) {
            System.out.println("Data source failed");
        }
        board = new Board(array);
        reduceAvailableValues();

    }

    private boolean readData() {
        array = new Input().getBoardData();
        return true;
    }

    public void reduceAvailableValues() {
        reduceAvailableValuesInRow();
        reduceAvailableValuesInColumn();
        reduceAvailableValuesInSquare();
    }

    private void reduceAvailableValuesInRow() {

        for (int i = 0; i < board.getTiles().length; i++) {
            for (int j = 0; j < board.getTiles().length; j++) {
                if (board.getTiles()[i][j].getAvailable() != null) {
                    for (int k = 0; k < board.getTiles().length; k++) {
                        if (board.getTiles()[i][k].getValue() > 0) {
                            board.getTiles()[i][j].remove(board.getTiles()[i][k].getValue());
                        }
                    }
                }
            }
        }
    }

    private void reduceAvailableValuesInColumn() {
        for (int i = 0; i < board.getTiles().length; i++) {
            for (int j = 0; j < board.getTiles().length; j++) {
                if (board.getTiles()[i][j].getAvailable() != null) {
                    for (int k = 0; k < board.getTiles().length; k++) {
                        if (board.getTiles()[k][j].getValue() > 0) {
                            board.getTiles()[i][j].remove(board.getTiles()[k][j].getValue());
                        }
                    }
                }
            }
        }
    }

    /**
     * Inspired by Miroslav Jackanin
     */
    private void reduceAvailableValuesInSquare() {

        int k = 0, l = 0, m = 0, n = 0;
        for (int i = 0; i < board.getTiles().length; i += 3) {
            for (int j = 0; j < board.getTiles().length; j += 3) {
                for (k += i; k < i + 3; k++) {
                    for (l += j; l < j + 3; l++) {
                        if (board.getTiles()[k][l].getAvailable() == null) {
                            for (m += i; m < i + 3; m++) {
                                for (n += j; n < j + 3; n++) {
                                    if (board.getTiles()[m][n].getAvailable() != null) {
                                        board.getTiles()[m][n].remove(board.getTiles()[k][l].getValue());
                                    }
                                }
                                n = 0;
                            }
                            m = 0;
                        }
                    }
                    l = 0;
                }
                k = 0;
            }
        }
    }

    public boolean checkIfComplete() {
        for (int i = 0; i < board.getTiles().length; i++) {
            for (int j = 0; j < board.getTiles().length; j++) {
                if (board.getTiles()[i][j].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void assignValues() {
        for (int i = 0; i < board.getTiles().length; i++) {
            for (int j = 0; j < board.getTiles().length; j++) {
                if (board.getTiles()[i][j].getAvailable() != null
                        && board.getTiles()[i][j].getAvailable().size() == 1) {
                    board.getTiles()[i][j].setValue(board.getTiles()[i][j].getAvailable().iterator().next());
                    board.getTiles()[i][j].remove(board.getTiles()[i][j].getValue());
                }
            }
        }
    }
}
