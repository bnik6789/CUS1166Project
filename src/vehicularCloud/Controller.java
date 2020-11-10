package vehicularCloud;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Controller {
	
	public Controller() 
	{
	    try
    	    {  
       		VehicularCloud VC = new VehicularCloud();
       		VC.readJobs("Job Owner Information.txt"); 
		System.out.println(completionTime("Job Owner Information.txt"));
     	    }
     	    catch(IOException e)
     	    {  
       		 JOptionPane.showMessageDialog(null, "Error opening accounts file.");
       		 return;
     	     }
	 
	}
	
	//Not sure about this
	public String completionTime(String filename) 
	         throws IOException
	   {  
	      try (Scanner in = new Scanner(new File(filename)))
	      {
	    	  int duration = in.nextInt();
	    	  String s = " ";
	    	  int i=1;
	    	  
	         while (in.hasNextInt())
	         {  
	        	s = s + "Job " + i + "Completion time: " + duration + "\n";
	            	duration = duration + in.nextInt();
	            	i++;
	         }
	         return s;
	      }
	      
	   }
	
}
