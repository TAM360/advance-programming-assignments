package ap_assignment2;

import java.io.IOException;

// Thread class for the PalindromeWriter. 
public class WriterThread extends Thread {
	
	// data member
	PalindromeWriter obj; 
	
	// constructor.
	WriterThread(PalindromeWriter obj) {
		this.obj = obj;
	}
	
	public void run() {
		try {
			obj.writeInFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
