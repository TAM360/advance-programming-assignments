package ap_assignment2;

import java.util.ArrayList;

/**
 * Description: PalindromeWorker.java takes an ArrayList of Strings 
 * seprates those words which are palindrome from the others and
 * stores them in "sharedList" ArrayList
 */

public class  PalindromeWorker {
	
	// Data members.
	protected ArrayList<String> bag;
	protected ArrayList<String> sharedList;
	private static int count = 0;
	// Constructor. 
	public PalindromeWorker(ArrayList<String> bag, ArrayList<String> sharedList) {
		this.bag = bag; 
		this.sharedList = sharedList;
	}
	
	public synchronized void findPalindromes() {
		
		
		// iterate through every word of the "bag" ArrayList. 
		try {
			
			for (int i = 0; i < bag.size(); i ++) {
				
				StringBuilder temp = new StringBuilder(bag.get(i));
				temp = temp.reverse();
				
				// case1: the word is a classical palindrome (i.e its reversed version is the same).
				// case2: the word is palindromic (reversed version exists in the "bag "ArrayList").
				// note: both cases are true. Hence words are dumped in the "sharedList" each time.
				
				
				if (bag.get(i).equals(temp.toString())  ) {
					
					sharedList.add(bag.get(i) + "\n" );
					count++;
					
				}
				else if (bag.contains(temp.toString())) {
					sharedList.add(temp + "\n" );
					count++;
				}
				
			}
			
		}
		
		catch (Exception e) {
			
			 System.out.println(e);
		}  
		
		
		//System.out.println("Thread # " + Thread.currentThread().getId() + ", palindrome_count: " + count);
		
		sharedList.add("Thread # " + Thread.currentThread().getId() + ", palindrome_count: " + count + "\n");
		
	}
	
	
	
}
