public class Job {

    private final int jobId;
    private final int startTime;
    private final int endTime;
    private final int weight;

    //All Jobs will have equal weights. Used for LambdaScheduler.
    public Job(int jobId,int startTime, int endTime){
        this(jobId,startTime,endTime,1);
    }

    //Jobs will have different weights assigned. Used for LambdaWeightedScheduler.
    public Job(int jobId, int startTime, int endTime, int weight){
        this.jobId = jobId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weight = weight;
    }

    public int getJobId(){
        return jobId;
    }

    public int getStartTime(){
        return startTime;
    }

    public int getEndTime(){
        return endTime;
    }

    public int getWeight(){
        return weight;
    }

}
