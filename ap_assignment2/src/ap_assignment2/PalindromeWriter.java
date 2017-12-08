package ap_assignment2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Descritption: PalindromWriter.java takes an ArrayList of Strings 
 * and writes it in the new text file 
 */

public class PalindromeWriter {

	// data member
	protected ArrayList<String> sharedList;
	private ArrayList<String> threadInfoList; 
	
	// constructor. 
	public PalindromeWriter(ArrayList<String> sharedList) {
		this.sharedList = sharedList;
		threadInfoList = new ArrayList<String>();
	}
	
	public synchronized void  writeInFile() throws IOException {
		
	   
		try {
			
			// file path
	        File statText = new File("/home/tam/Documents/codes/java/ap_assignment2/src/ap_assignment2/answer");
	        FileOutputStream is = new FileOutputStream(statText);
	        OutputStreamWriter osw = new OutputStreamWriter(is);    
	        Writer w = new BufferedWriter(osw);
	        
	        //System.out.println(sharedList.size());
	        
	        // we have to seprate the words from the thread info strings.
	        
	        for (int i =0; i < sharedList.size(); i ++) {
	        	
	        	// string at ith index is a palindrome.
	        	if (!sharedList.get(i).contains("palindrome_count")) {
	        		 w.write(sharedList.get(i));
	        	}
	        	
	        	// string at ith index is an info about the PalindromeWorker thread itself.
	        	else {
	        		threadInfoList.add(sharedList.get(i));
	        		//sharedList.remove(i);
	        	}
	        }
	        
	        for (int i =0; i < threadInfoList.size(); i ++) {
	        	w.write(threadInfoList.get(i));
	        }
	        
	        
	        
	        w.close();
	       
    	} 
		catch (IOException e) {
			System.err.println("Problem writing to the file 'answer' text file");
		}
	}
	
	
}
