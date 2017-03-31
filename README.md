# CS9053-Homework-8
Job Scheduling

Using Java Collections, create a solution to the following problem.
    - You have just graduated NYU!  Congratulations (w00t w00t)!  Even better, you have taken a great job at Amazon working on the AWS platform, specifically the AWS Lambda team.  The first task at your new job is to optimize the cluster of EC2 machines which are running the Lambda jobs in containers.  Specifically you need to create a scheduler of Lambda jobs which maximizes the number of jobs a single container can accept.  For context, each Lambda job consists of the following: a starting time _s_ until a final time _t_.  You can assume the job can be run by at most one container at a time.  Given a list of jobs you must accept a subset of the jobs, rejecting all others, so that the accepted jobs do not overlap in time.

    - Place this within directory/file `src/main/java/edu/nyu/cs9053/homework8/LambdaScheduler.java`

    - More formally, there will be _n_ jobs labeled _1...n_ with each job, _j_, specifying a start time _Sj_ and a finish time _Tj_.  Naturally we have _Sj_ < _Tj_ for all _j_.  Two jobs _j_ and _j1_ are compatible if the requested intervals do not overlap; that is, either job _j_ is for an earlier time interval than job _j1_ (_Tj_ <= _Sj1_), or job _j_ is for a later time than job _j1_ (_Tj1_ <= _Sj_).  More generally, that a subset _A_ of jobs is compatible if all pairs of jobs _j_,_j1_ within _A_, _j_ != _j1_ are compatible.  The goal is to select a compatible subset of jobs of maximum possible size.  To illustrate, for the following jobs the single compatible set of size 4 is the largest compatible set.
```
                 |-----------|                    |--------------|
               |--------|                       |-----------|
              |--------------|    |----------| |--------------|
   |--------------|   |--------------|   |--------------|   |--------------|
===============================================================================>
```

* Again, using Java Collections, solve the above problem but change the problem to be slightly more complicated.
    - After successfully implementing the above problem in less than two days, your boss at AWS is impressed.  The team is thinking about introducing prioritized jobs within Lambda.  In this case someone would pay more money to have their job run first.  Make an extension to your work that instead of optimizing for the number of jobs, you now maximize for the total value (i.e. each job now as an associated cost or weight and you're optimizing for the largest cost).
