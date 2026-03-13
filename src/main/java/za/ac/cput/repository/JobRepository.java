package za.ac.cput.repository;

import za.ac.cput.domain.Job;

import java.util.HashSet;
import java.util.Set;

public class JobRepository implements IRepository<Job, String> {
    private static JobRepository repository = null;
    private final Set<Job> jobs;

    private JobRepository() {
        this.jobs = new HashSet<>();
    }

    public static JobRepository getRepository() {
        if (repository == null) {
            repository = new JobRepository();
        }
        return repository;
    }

    @Override
    public Job create(Job job) {
        this.jobs.add(job);
        return job;
    }

    @Override
    public Job read(String jobTitle) {
        return findByJobTitle(jobTitle);
    }

    @Override
    public Job update(Job job) {
        Job oldJob = findByJobTitle(job.getJobTittle());
        if (oldJob != null) {
            this.jobs.remove(oldJob);
            this.jobs.add(job);
            return job;
        }
        return null;
    }

    @Override
    public boolean delete(String jobTitle) {
        Job job = findByJobTitle(jobTitle);
        if (job != null) {
            this.jobs.remove(job);
            return true;
        }
        return false;
    }

    @Override
    public Set<Job> getAll() {
        return this.jobs;
    }

    private Job findByJobTitle(String jobTitle) {
        return this.jobs.stream()
                .filter(job -> job.getJobTittle().equals(jobTitle))
                .findAny()
                .orElse(null);
    }
}
