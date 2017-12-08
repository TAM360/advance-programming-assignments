package HangManApplication;

/**
 * @authors Taimoor Mirza & Husnain Ajmal
 * @RollNumbers 14-4520 & 14-4491
 * @Assignment 1
 * @Question 1
 * @Description HangmanLexicon generates a 10 word word list which 
 * 				is used in the game.
 * */


public class HangmanLexicon {

    // constructor. 
    HangmanLexicon(){
    	
    }
    
    /** Returns the number of words in the lexicon. */
    public int getWordCount() {
        return 10;
    }


    /** Returns the word at the specified index. */

    public String getWord(int index) {
        switch (index) {

            case 0:
                return "BUOY";
            case 1:
                return "COMPUTER";
            case 2:
                return "CONNOISSEUR";
            case 3:
                return "DEHYDRATE";
            case 4:
                return "FUZZY";
            case 5:
                return "HUBBUB";
            case 6:
                return "KEYHOLE";
            case 7:
                return "QUAGMIRE";
            case 8:
                return "SLITHER";
            case 9:
                return "ZIRCON";
            default:
                return new String("Illegal index");
        }
    }
}

