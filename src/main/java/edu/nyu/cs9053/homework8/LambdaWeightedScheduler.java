import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaWeightedScheduler {

    static public List<Job> findMaxWeight(List<Job> jobs){

        if(jobs==null){
            throw  new IllegalArgumentException("jobs must not be null");
        }

        // Sort jobs according to end time
        jobs.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.getEndTime() - o2.getEndTime();
            }
        });

        jobs.add(0,new Job(0,0,0));

        // stores the profit for jobs till index i (including i)
        int[] weightTable = new int[jobs.size()];
        weightTable[0] = 0;

        int[] lastNonConflictJobIndex = new int[jobs.size()];
        lastNonConflictJobIndex[0] = 0;

        //Constructing the optimal solution
        for(Job job : jobs){
            if(job == null)
                continue;
            int currentIndex = jobs.indexOf(job);
            int currentWeight = job.getWeight();
            lastNonConflictJobIndex[currentIndex] = latestNonConflict(jobs,currentIndex);
            currentWeight += weightTable[lastNonConflictJobIndex[currentIndex]];
            if(currentIndex>0)
            weightTable[currentIndex] = Math.max(currentWeight, weightTable[currentIndex-1]);
        }

       return selectedJobList(jobs,weightTable,lastNonConflictJobIndex);
    }

    //Constructing the optimal jobset
    static  private List<Job> selectedJobList(List<Job> jobs, int[] weightTable, int[] lastNonConflictJobIndex ) {
        List<Job> optimalJobList = new ArrayList<>();
        int currentIndex= jobs.size()-1;
        while (currentIndex > 0)    {
            if (jobs.get(currentIndex).getWeight() + weightTable[lastNonConflictJobIndex[currentIndex]] >= weightTable[currentIndex-1])  {
                optimalJobList.add(jobs.get(currentIndex));
                System.out.println(jobs.get(currentIndex).getWeight());
                currentIndex = lastNonConflictJobIndex[currentIndex];
            } else
                currentIndex--;
        }
        return optimalJobList;
    }

    //Implemented binary search to optimize the time complexity of searching to O(log n)
    static private int latestNonConflict(List<Job> jobs, int high) {
        int left = 0;
        int right = high-1;
        int target = jobs.get(high).getStartTime();
        while(left<right) {
            int mid = left + (right-left+1) / 2;
            if(jobs.get(mid).getEndTime() <= target)
            {
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
        if(jobs.get(left).getEndTime()>target)
            return 0;
        return left;
    }

}
