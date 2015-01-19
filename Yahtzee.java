/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

import java.util.ArrayList;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {

    private static final int NUM_OF_ROUNDS = 13;
    private static final int ONES_SCORE = 1;
    private static final int TWOS_SCORE = 2;
    private static final int THREES_SCORE = 3;
    private static final int FOURS_SCORE = 4;
    private static final int FIVES_SCORE = 5;
    private static final int SIXES_SCORE = 6;
    private static final int FULL_HOUSE_SCORE = 25;
    private static final int SMALL_STRAIGHT_SCORE = 30;
    private static final int LARGE_STRAIGHT_SCORE = 40;
    private static final int YAHTZEE_SCORE = 50;


    public static void main(String[] args) {
        new Yahtzee().start(args);
    }

    public void run() {
        IODialog dialog = getDialog();
        nPlayers = dialog.readInt("Enter number of players");
        playerNames = new String[nPlayers];
        for (int i = 1; i <= nPlayers; i++) {
            playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
        }
        display = new YahtzeeDisplay(getGCanvas(), playerNames);
        playGame();
    }

    private void playGame() {
        initScores();
        for (int rounds = 0; rounds < NUM_OF_ROUNDS; rounds++) {
            for (int player = 1; player <= nPlayers; player++) {
                display.printMessage(playerNames[player-1] + "'s turn, Please roll dice");
                display.waitForPlayerToClickRoll(player);
                rollDice();
                display.printMessage("Please select a category for your dice");
                checkCategory(display.waitForPlayerToSelectCategory());
            }
        }
        //assignScores();
        //endGame();
    }

    private void initScores(){
        scores = new int[nPlayers][N_CATEGORIES];
    }

    /**
     * This method gives the player a chance to roll the dice three times
     */
    private void rollDice() {
        firstDiceRoll();
        reroll();
        reroll();
    }

    /**
     * The first dice roll where a random number for each die is assigned
     */
    private void firstDiceRoll() {
        for (int i = 0; i < N_DICE; i++) {
            dice[i] = generateDiceNum();
        }
        display.displayDice(dice);
    }

    /**
     * The second and third dice roll which only changes the the dice that the user selected
     */
    private void reroll() {
        display.printMessage("Please select the dice you want to reroll and click \"Roll Again\".");
        display.waitForPlayerToSelectDice();
        for (int i = 0; i < N_DICE; i++) {
            if (display.isDieSelected(i)) {
                dice[i] = generateDiceNum();
            }
        }
        display.displayDice(dice);
    }

    /**
     * Generates a valid random die roll
     */
    private int generateDiceNum() {
        return rgen.nextInt(1, 6);
    }

    private void checkCategory(int category){
        switch (category){
            case ONES:
                break;
            case TWOS:
                break;
            case THREES:
                break;
            case FOURS:
                break;
            case FIVES:
                break;
            case SIXES:
                break;
            case UPPER_SCORE:
                break;
            case UPPER_BONUS:
                break;
            case THREE_OF_A_KIND:
                break;
            case FOUR_OF_A_KIND:
                break;
            case FULL_HOUSE:
                break;
            case SMALL_STRAIGHT:
                break;
            case LARGE_STRAIGHT:
                break;
            case YAHTZEE:
                break;
            case CHANCE:
                break;
            case LOWER_SCORE:
                break;
            case TOTAL:
                break;
        }
    }

    /* Private instance variables */
    private int nPlayers;
    private String[] playerNames;
    private YahtzeeDisplay display;
    private RandomGenerator rgen = new RandomGenerator();
    private int[] dice = new int[N_DICE];
    private int [][] scores;
    private boolean isCategory;
    private ArrayList<Integer> categories = new ArrayList<Integer>();

}
