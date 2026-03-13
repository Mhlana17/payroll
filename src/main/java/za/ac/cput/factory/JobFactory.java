package za.ac.cput.factory;

import za.ac.cput.domain.Job;
import za.ac.cput.util.Helper;

public class JobFactory {
    public static Job createJob(String jobTittle) {
        if (Helper.isNullOrEmpty(jobTittle))
            return null;

        return new Job.Builder().setJobTittle(jobTittle).build();
    }
}