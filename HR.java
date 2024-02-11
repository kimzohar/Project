package Staff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import Workers.*;



public class HR implements Serializable{
	
	private ArrayList<Worker>workerList= new ArrayList<Worker>();

	public HR(ArrayList<Worker> workerList) {
	setWL(workerList);

	}

	public ArrayList<Worker> getWorkerList() {
	return workerList;
	}

	public void setWL(ArrayList<Worker> workerList) {
	this.workerList = workerList;
	}

	public void AddWorker(Worker newW) throws AddWorkerExp {
	  for(Worker i :this.workerList) {
	    if((i.getId()).equals(newW.getId())){
	    throw new AddWorkerExp("The worker: "+ i + " is already exist.");
	    }
	}
	    this.workerList.add(newW);
	System.out.println("The worker: "+newW+ " added successfully to the system.");
	}
	
	
	public Worker findworker(String id) throws FindWorkerExp{
	  for (Worker i:workerList) {
       	 if (i.getId().equals(id)) {
	     return i;
     	}
	}
	return null;	
	}

	public String toString() {
	String str="";
	Collections.sort(workerList);
	
	for(Worker worker :this.workerList)
	    str += worker.toString()+"\n";
	return str;
	}

	public void removeworker(String id)throws RemoveWorkerExp{
	   Worker remove = null;
	   for (int i = 0; i<workerList.size();i++) {
   		Worker worker = workerList.get(i);
	       if (worker.getId().equals(id)){
            	remove = worker;
	break;
	}
	}
	      if (remove != null) {
	          System.out.println(remove);
	          workerList.remove(remove);
              System.out.println("The worker has been Removed");
	}else 
	{
	throw new RemoveWorkerExp("Worker doesn't exist.");
	}
	}

	

}
