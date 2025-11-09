package com.practice.JobWithJPA.service;

import com.practice.JobWithJPA.model.JobPost;
import com.practice.JobWithJPA.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobPost){
        System.out.println("Inside add");
        repo.save(jobPost);
    }
    public List<JobPost> returnAllJobs(){
      return repo.findAll();
    }
    public JobPost getJob(int jobId){
        return repo.findById(jobId).orElse(new JobPost());
    }

//    public void updatePost( JobPost jobPost) {
//        repo.updatePost(jobPost);
//        System.out.println("Success");
//      //  return jobPost;
//    }
    public String updateJob(JobPost jobPost) {
        repo.save(jobPost);
        return "Success";
    }
    public void load() {
        // arrayList to store store JobPost objects
        List<JobPost> jobs =
                new ArrayList<>(List.of(
                        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))

                ));

        repo.saveAll(jobs);

    }
}
