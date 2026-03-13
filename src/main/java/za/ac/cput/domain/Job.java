package za.ac.cput.domain;

public class Job {
    protected String jobTittle;

    public Job(){

    }
    public Job (Builder builder){
        this.jobTittle = builder.jobTittle;
    }

    public String getJobTittle() {
        return jobTittle;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobTittle='" + jobTittle + '\'' +
                '}';
    }

    public static class Builder {
        private String jobTittle;

        public Builder setJobTittle(String jobTittle) {
            this.jobTittle = jobTittle;
            return this;
        }
        public Builder copy(Job job){
            this.jobTittle = job.jobTittle;
            return this;
        }
        public Job build(){
            return new Job(this);
        }
    }
}//end of class