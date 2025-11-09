package com.practice.JobWithJPA.controller;

import com.practice.JobWithJPA.model.JobPost;
import com.practice.JobWithJPA.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJObs(){
        return service.returnAllJobs();
    }
    @PostMapping("jobPost")
    public JobPost jobPost(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getJobId());
    }
    @GetMapping("jobPost/{jobId}")
    public JobPost jobPost(@PathVariable int jobId){
        return service.getJob(jobId);
       // System.out.println(jobId);
    }
//    @PutMapping("jobPost")
//    public JobPost updatePost(@RequestBody JobPost jobPost){
//        service.updatePost(jobPost);
//        return jobPost;
//    }

    @PutMapping("jobPost")
    public JobPost updatePost(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return jobPost;
    }
    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }

}
