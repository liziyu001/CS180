package pj3;

import java.io.*;
import java.util.Scanner;
/**
 * Store PlayGame class
 *
 * <p>Purdue University -- CS18000 -- Summer 2021</p>
 *
 * @author Purdue CS
 * @version Oct 26, 2021
 */
public class PlayGame {
    public static void main(String[] args) throws IOException {
        char[][] board1 = read("ShipPositionsPlayerOne.txt");
        char[][] board2 = read("ShipPositionsPlayerTwo.txt");
        int hit1 = 0;
        int hit2 = 0;
        int row = 0;
        int column = 0;
        int counter = 1;
        int winner = 0;
        String pattern1 = patternAnalyzer(board1);
        String pattern2 = patternAnalyzer(board2);
        System.out.println("Hello, Welcome to Battleship!");
        Scanner s = new Scanner(System.in);
        while (true) {

            System.out.println("Player 1 - Enter a row letter from A - J");
            row = s.nextLine().charAt(0) - 65;
            System.out.println("Player 1 - Enter a column number from 1 - 14");
            column = Integer.parseInt(s.nextLine()) - 1;
            System.out.println("Value:" + board2[row][column]);
            if (board2[row][column] == 'H') {
                hit1++;
                board2[row][column] = 'M';
            }
            if (hit1 == 17) {
                winner = 1;
                System.out.println("Enemy fleet destroyed. Congratulations player 1!");
                break;
            }
            System.out.println("Player 2 - Enter a row letter from A - J");
            row = s.nextLine().charAt(0) - 65;
            System.out.println("Player 2 - Enter a column number from 1 - 14");
            column = Integer.parseInt(s.nextLine()) - 1;
            System.out.println("Value:" + board1[row][column]);
            if (board1[row][column] == 'H') {
                hit2++;
                board1[row][column] = 'M';
            }
            if (hit2 == 17) {
                winner = 2;
                System.out.println("Enemy fleet destroyed. Congratulations player 2!");
                break;
            }
            counter++;
        }
        if (winner == 1) {
            GameLog g = new GameLog(winner, hit2, counter, pattern1, pattern2);
            File f = new File("GameLog.txt");
            FileOutputStream fos = new FileOutputStream(f, false);
            PrintWriter pr = new PrintWriter(fos);
            pr.println(g.toString());
            pr.close();
        } else if (winner == 2) {
            GameLog g = new GameLog(winner, hit1, counter, pattern1, pattern2);
            File f = new File("GameLog.txt");
            FileOutputStream fos = new FileOutputStream(f, false);
            PrintWriter pr = new PrintWriter(fos);
            pr.println(g.toString());
            pr.close();
        }

    }

    public static char[][] read(String fileName) throws IOException {
        char[][] board = new char[10][14];
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        for (int i = 0; i < 10; i++) {
            String line = bfr.readLine();
            for (int j = 0; j < 14; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        bfr.close();
        return board;
    }

    public static String patternAnalyzer(char[][] board) {


        boolean top = false;
        boolean middle = false;
        boolean bottom = false;
        int counter = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 14; j++) {
                if (board[i][j] == 'H') {
                    counter++;
                    if (counter == 9) {
                        top = true;
                    }
                }
            }

        }
        counter = 0;
        for (int i = 3; i < 7; i++) {

            for (int j = 0; j < 14; j++) {
                if (board[i][j] == 'H') {
                    counter++;
                    if (counter == 9) {
                        middle = true;
                    }
                }
            }

        }
        counter = 0;
        for (int i = 7; i < 10; i++) {

            for (int j = 0; j < 14; j++) {
                if (board[i][j] == 'H') {
                    counter++;
                    if (counter == 9) {
                        bottom = true;
                    }
                }
            }

        }
        if (top) {
            return "Top Heavy";
        } else if (middle) {
            return "Middle Heavy";
        } else if (bottom) {
            return "Bottom Heavy";
        } else {
            return "Scattered";
        }
    }

}
