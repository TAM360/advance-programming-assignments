package HangManApplication;

import java.util.ArrayList;
import java.util.Random;

/**
 * @authors Taimoor Mirza & Husnain Ajmal
 * @RollNumbers 14-4520 & 14-4491
 * @Assignment 1
 * @Question 1
 * @Description Hangman class 
 * */


public class HangMan {
	
    String MysteryWord;
    StringBuilder currentGuess;
    ArrayList<Character> OldGuesses = new ArrayList<Character>();
    
    //ArrayList<String> Dictionary = new ArrayList<String>();
    private HangmanLexicon Dictionary = new HangmanLexicon();
    int MaxTries = 8;
    int Tries = 0;
    
    // constructor
    HangMan() {
    	
        Random num = new Random();
        int index = num.nextInt(9) + 0; // generate a random number
        MysteryWord = Dictionary.getWord(11); // use the random number to extract a word from the dictionary.11
        MysteryWord = MysteryWord.toUpperCase();
        currentGuess = InitCurrentGuess();
        
        
    }
    
    public StringBuilder InitCurrentGuess() {
    	
        StringBuilder current = new StringBuilder();
        
        for (int i = 0; i < MysteryWord.length() ; i++) {
            
        	// in the guess we append _ symbols along to show blank letters. 
        	
        	current.append("_"); 
        }
        return  current;
    }
    
    // checks whether user's guess is correct or not.
    public boolean GoodGuess(char guess) {
    	
        boolean IfMyGuessIsGood = false;
        
        for (int i = 0; i < MysteryWord.length(); i++) {
           
        	if(MysteryWord.charAt(i) == guess) {
        		
               currentGuess.setCharAt(i , guess); // replacing the blank dash with the user's guess.
               
               OldGuesses.add(guess);
               IfMyGuessIsGood = true;
           }
        }
        
        if(!IfMyGuessIsGood){
        	Tries ++;
        }
        
        return IfMyGuessIsGood;
    }
    
    public boolean gameOver() {
    	
    	String OriginalGuess = currentGuess.toString();
    	System.out.println(OriginalGuess.length());
        
        boolean GameEnds = false;
        //System.out.println(MysteryWord.compareTo(OriginalGuess));
        
        if(MysteryWord.equals(OriginalGuess)) {
            
        	System.out.println("\nCongrats!! You won the Game");
            GameEnds = true;
        }
        else if(getTotalTries() <= 0)
        {
        	
            GameEnds =  false;
        }
       
        
        
        return GameEnds;
    }

    public boolean IsGuessAlready(char guess){
    	return OldGuesses.contains(guess);
    }
    
    public String getCurrentGuess() {
    	System.out.print("Current Guess ");
    	return   currentGuess.toString();
    }
    
    public int getTotalTries() {
    	return MaxTries - Tries;
    }

}
