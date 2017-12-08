package ap_assignment1;

/**
 * @authors Taimoor Mirza & Husnain Ajmal
 * @RollNumbers 14-4520 & 14-4491
 * @Assignment 1
 * @Question 2
 * @Description Program finds out a sentence/consecutive sequence of sentences 
 * 				which have the size min <= length =< max where @min and @max are 
 * 				the extreme bounds.
 * */


import java.util.Scanner;

public class FindSentences {

	public static void main(String[] args) {
		
			
		int min = 0, max = 0, totalSentences = 0;
		String str = null; 
		
		// case 1: user sends the min, max and string values via terminal.
		if (args.length == 3) {
			 
			min = Integer.parseInt(args[0]);
			max = Integer.parseInt(args[1]); 
			str = new String(args[2]); 
			
		}
		// case 2: user is asked to enter the data
		else {
			Scanner sc = new Scanner(System.in); 
			System.out.println("Enter the min value: ");
			min = sc.nextInt(); 
			
			System.out.println("Enter the max value: ");
			max = sc.nextInt();
			
			System.out.println("Enter a string: " );
			sc = new Scanner (System.in);
			str = new String(sc.nextLine()); 
			
		}
		
		//System.out.println(min + "," + max + "," + str + "\n");
		
		// count the total # of sentences in the given string. 
		for (int i =0; i < str.length(); i ++) {
			if (str.charAt(i) == '.' || str.charAt(i) == '!' || str.charAt(i) == '?') 
				totalSentences ++; 
		}
		
		//System.out.println(totalSentences + "\n");
		
		StringBuffer sentences[] = new StringBuffer[totalSentences];
		
		// initializing each StringBuffer. 
		for (int  i = 0; i < totalSentences; i ++) 
			sentences[i] = new StringBuffer();
		
		// seperate the sentences into individual StringBuffer variables. 
		for (int i =0, j = 0; i < str.length(); i ++) {
			
			if (str.charAt(i) != '.' && str.charAt(i) != '!' && str.charAt(i) != '?') {
				sentences[j].append(str.substring(i, i+1));
				
			}		
			else {
				sentences[j].append(str.substring(i, i+1)); // this appends . or ? or !
				j++;
				
			}
				
		}
		
		//for (int  i = 0; i < totalSentences; i ++) 
			//System.out.println(sentences[i]);
		
		
		for (int  i = 0; i < totalSentences; i ++) {
			
			// base case: single sentence has the length b/w min & max.
			if (sentences[i].length() >= min && sentences[i].length() <= max) {
				System.out.println(sentences[i]);
			}
			// combination of sentences which has the length in b/w min & max.
			else {
					
				StringBuffer temp = new StringBuffer(sentences[i]);
				
				for (int j = i + 1; j < totalSentences; j ++) {
					temp.append(sentences[j]);
					
					if (temp.length() >= min && temp.length() <= max) 
						System.out.println( temp);
				}
			}
		}
		
		
	}

}
