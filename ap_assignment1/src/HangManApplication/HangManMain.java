package HangManApplication;

/**
 * @authors Taimoor Mirza & Husnain Ajmal
 * @RollNumbers 14-4520 & 14-4491
 * @Assignment 1
 * @Question 1
 * @Description Driver class for the hangman game.
 * */

import java.util.Scanner;

public class HangManMain
{

    public static void main(String[] args) {
	
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome! Lets Play HangMan");
        
        //System.out.println("Description");
        boolean play = true;
        while (play ) {

            
            HangMan game = new HangMan();

            while(game.gameOver() == false && game.getTotalTries() > 0) {
            	
            	// keep playing the game
                //System.out.println("\n" +game.getCurrentGuess());
                
                String temp = game.getCurrentGuess();
                for (int i = 0; i < temp.length(); i ++) {
                	System.out.print(temp.charAt(i) + " ");
                }
                System.out.println("\n");
                //System.out.println(game.MysteryWord);
              
                System.out.println("Total tries remaining: " + game.getTotalTries());
                
                //Get the Guess
                System.out.println("Enter a Character ");
                char guess = scan.next().toUpperCase().charAt(0);
                //System.out.println(guess);

                //Check if letter is Already Guessed
                while(game.IsGuessAlready(guess))
                {
                    System.out.println("This Character is Already been Guessed Try another one!");
                    guess = scan.next().toUpperCase().charAt(0);
                }

                //Check if Guess Is correct??
                if (game.GoodGuess(guess)) {
                	System.out.println("Good Guess. This letter is in the Word. Carry On!");
                }
                else {
                	System.out.println("Bad Guess!! This letter is not in the Word.Try Again!");
                }


            }
            
            // If the player has lost the game, we have to display the answer.
            
            if (game.getTotalTries() <= 0)
            	System.out.println("You have failed :( The answer is " + game.MysteryWord );
            
            System.out.println("do you want to play again???");
            //No Matter what Character user enters..it is converted in to Upper case
            Character resp = (scan.next().toUpperCase()).charAt(0);
            play =  (resp =='Y' || resp =='y'); //Enter Y or y to continue

        }

    }
}
