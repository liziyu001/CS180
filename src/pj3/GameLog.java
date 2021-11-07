package pj3;

/**
 * Project 3
 * <p>
 * GameLog class
 *
 * @author Ziyu Li
 * @version October 26, 2021
 */
public class GameLog {
    private int winningPlayer;
    private int losingPlayerHits;
    private int numTurns;
    private String boardPatternOne;
    private String boardPatternTwo;

    public GameLog(int winningPlayer, int losingPlayerHits, int numTurns, String boardPatternOne,
                   String boardPatternTwo) {
        this.winningPlayer = winningPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternOne = boardPatternOne;
        this.boardPatternTwo = boardPatternTwo;
    }

    public String toString() {
        if (winningPlayer == 1) {
            return "Battleship Game Log:\nWinning Player: Player " + winningPlayer + "\nHits: 17 - " + losingPlayerHits
                    + "\nNumber of Turns To Win: "
                    + numTurns + "\nPlayer 1 Board Pattern: " + boardPatternOne
                    + "\nPlayer 2 Board Pattern: " + boardPatternTwo;
        } else {
            return "Battleship Game Log:\nWinning Player: Player " + winningPlayer + "\nHits: " + losingPlayerHits
                    + " - 17\nNumber of Turns To Win: "
                    + numTurns + "\nPlayer 1 Board Pattern: " + boardPatternOne
                    + "\nPlayer 2 Board Pattern: " + boardPatternTwo;
        }

    }
}
