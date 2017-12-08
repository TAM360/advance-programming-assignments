package ap_assignment2;

import java.util.ArrayList;

// Thread class for the PalindromeWorker. 
public class WorkerThread extends Thread {
	
	// Data member. 
	private PalindromeWorker obj; 
	
	// Constructor. 
	public WorkerThread(PalindromeWorker obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		obj.findPalindromes();
	}

}
