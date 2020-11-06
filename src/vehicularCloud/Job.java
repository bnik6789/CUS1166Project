package vehicularCloud;

public class Job {
	private int id, JobDuration;
	
	public Job(int id,int JobDuration) 
	{
		this.JobDuration = JobDuration;
		this.id = id;
	}
	
	public int getJobId() 
	{
		return this.id;
	}
	
	public int getJobDuration() 
	{
		return this.JobDuration;
	}
}
