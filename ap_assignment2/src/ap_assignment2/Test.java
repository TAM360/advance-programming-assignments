package ap_assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Taimoor Mirza
 * @rollNumber 14-4520
 * Assignment #2
 * Descrption: Driver class of the assignment. 
 */

public class Test {

	public static void main(String [] args) {
		
		HashMap<String, ArrayList<String>> bagOfTasks = new HashMap<String, ArrayList<String>>();
		ArrayList<String> bag = null; // This will reference 1 ArrayList of strings at 1 time.
		ArrayList<String> sharedList = new ArrayList<String>();
		
		// contains all the keys of "bagOfTasks" HashMap.
		String keyList[] = {"11","22","12","13","14",
                			"15","16","17","18","1",
            				"2","3","4","5","6",
            				"7","8","9","10","21"};
		int totalThreads = 0;
		
        // File path.
        String fileName = "/home/tam/Documents/codes/java/ap_assignment2/src/ap_assignment2/words";

        // This will reference one line at a time
        String line = null;

        try {
        	
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	
                
            	String temp = line.length() + "";
            	
            	// check if the key-value pair exists already.
            	if(bagOfTasks.containsKey(temp)) {
            		
            		bagOfTasks.get(temp).add(line);
            		
            		
            	}
            	// if not then new arrayList is created with new key.
            	else {
            		
            		bag = new ArrayList<String>();
            		bag.add(line);
            		bagOfTasks.put(line.length() + "", bag);
            		
            	}
            	
            }   

            // Always close files.
            bufferedReader.close();         
        }
        
        catch(FileNotFoundException ex) {
            System.out.println( "Unable to open file '" + fileName + "'");                
        }
        
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            
        }
        
        //System.out.println(bagOfTasks.get("2"));
        
        // taking user input as # of threads.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of threads:");
        totalThreads = sc.nextInt();
        
        // thread pool has helped me in resolving the stupid synchronization 
        // issues. God bless the man who made this class!!! 
        ExecutorService executor = Executors.newFixedThreadPool(totalThreads);
        PalindromeWorker obj;
        
        WorkerThread thread;
        
        for (int i = 0; i < keyList.length; i ++) {
        	
        	obj = new PalindromeWorker(bagOfTasks.get(keyList[i]), sharedList);
        	thread = new WorkerThread(obj); 
        	executor.execute(thread);
        	
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        
        }
        sharedList.add("Total Palindromes Found:" +(sharedList.size() -20 ) + "\n");
        
        WriterThread x = new WriterThread(new PalindromeWriter(sharedList));
        x.start();
       
    }

	

}
