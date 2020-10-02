package sk.itsovy.kutka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
    public String accessFile() {
        StringBuilder stringBuilder = new StringBuilder();
        String source = "C:\\Users\\jacob\\IdeaProjects\\SudokuSolver\\src\\input.txt";
        try {
            File myFile = new File(source);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringBuilder.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public int[][] getBoardData() {
        String data = accessFile();
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = (data.charAt(9 * i + j)) - '0';
            }
        }
        return arr;
    }
}
