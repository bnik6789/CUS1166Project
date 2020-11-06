package vehicularCloud;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicularCloud {
	
	public ArrayList<Job> jobsList;
	
	public VehicularCloud() 
	{
		jobsList = new ArrayList<Job>();
	}
	
	 public void addJob(Job j)
	   {  
	      jobsList.add(j);
	   }
	
	public void readJobs(String filename) 
	         throws IOException
	   {  
	      try (Scanner in = new Scanner(new File(filename)))
	      {
	    	  int i = 1;
	         while (in.hasNextInt())
	         {  
	            int jobDur = in.nextInt();
	            Job j = new Job(i, jobDur);
	            addJob(j);
	            i++;
	         }
	      }
	   }
	
	
	/*
	public Job manageJob() {
		return null;
		
	}
	
	public Vehicle manageVehicle() {
		return null;
		
	}
	
	public void organizeVehicles() {
		
	}
	
	public Controller addController() {
		return null;
		
	}*/
}
