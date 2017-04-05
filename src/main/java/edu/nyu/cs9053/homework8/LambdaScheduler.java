import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaScheduler {

    static public List<Job> findMaxSizeOfContainer(List<Job> jobs){

        if(jobs==null){
            throw  new IllegalArgumentException("jobs must not be null");
        }

        Job previousJob = jobs.get(0);

        // Sort jobs according to end time.
        jobs.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.getEndTime() - o2.getEndTime();
            }
        });

        List<Job> selectedJobs = new ArrayList<>();

        // The first activity always gets selected.
        selectedJobs.add(jobs.get(0));

        for(Job job : jobs) {
            if(job == null)
                continue;
            if(job.getStartTime() >= previousJob.getEndTime()) {
                selectedJobs.add(job);
                previousJob = job;
            }
        }

        return selectedJobs;
    }

}
