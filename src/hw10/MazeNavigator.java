
package hw10;

import java.io.*;
import java.util.ArrayList;

public class MazeNavigator extends Thread {
    private static int currentRow;
    private static int currentColumn;
    private static int moveNumber;
    private static boolean started;
    public static char[][] maze;
    private int playerNumber;
    private String fileName;
    private ArrayList moves = new ArrayList();
    public static Object obj = new Object();

    public MazeNavigator(int playerNumber, String fileName) {
        maze = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                maze[i][j] = ' ';
            }
        }
        maze[4][4] = 'X';
        this.fileName = fileName;
        this.playerNumber = playerNumber;
        currentColumn = 4;
        currentRow = 4;
        moveNumber = 0;
        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String line = bfr.readLine();
            while (line != null) {
                this.moves.add(line);
                line = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        if (!started) {
            this.started = true;
            synchronized (obj) {
                System.out.println("Welcome! Initial Maze:");
                printMaze();
            }
        }


        for (int i = 0; i < moves.size(); i++) {
            synchronized (obj) {
                switch (Integer.parseInt((String) moves.get(i))) {
                    case 3:
                        maze[currentRow][currentColumn] = ' ';
                        currentRow--;
                        if (currentRow < 0) {
                            currentRow = 9;
                        }
                        maze[currentRow][currentColumn] = 'X';
                        moveNumber++;
                        break;
                    case 4:
                        maze[currentRow][currentColumn] = ' ';
                        currentRow++;
                        if (currentRow > 9) {
                            currentRow = 0;
                        }
                        maze[currentRow][currentColumn] = 'X';
                        moveNumber++;
                        break;
                    case 1:
                        maze[currentRow][currentColumn] = ' ';
                        currentColumn--;
                        if (currentColumn < 0) {
                            currentColumn = 9;
                        }
                        maze[currentRow][currentColumn] = 'X';
                        moveNumber++;
                        break;
                    case 2:
                        maze[currentRow][currentColumn] = ' ';
                        currentColumn++;
                        if (currentColumn > 9) {
                            currentColumn = 0;
                        }
                        maze[currentRow][currentColumn] = 'X';
                        moveNumber++;
                        break;
                    default:
                        System.out.println("Error, invalid input!");
                }
            }
            synchronized (obj) {
                printInfo(Integer.parseInt((String) moves.get(i)));
                printMaze();
            }


        }
    }

    public void printMaze() {

        for (int i = 0; i < 10; i++) {
            System.out.print('[');
            for (int j = 0; j < 9; j++) {
                System.out.print(maze[i][j]);
                System.out.print(',');
            }
            System.out.print(maze[i][9]);
            System.out.print(']');
            System.out.println();
        }
    }

    public synchronized void printInfo(int m) {
        String move = "";
        System.out.println("Move number: " + this.moveNumber);
        System.out.println("Player: " + playerNumber);
        switch (m) {
            case 1:
                move = "Left";
                break;
            case 2:
                move = "Right";
                break;
            case 3:
                move = "Up";
                break;
            case 4:
                move = "Down";
                break;
        }
        System.out.println("Move: " + move);
    }

    public static void main(String[] args) {
        try {
            MazeNavigator[] mazeNavigators = {new MazeNavigator(1, "PlayerOneMoves.txt"),
                    new MazeNavigator(2, "PlayerTwoMoves.txt")};

            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].start();
            }
            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}
