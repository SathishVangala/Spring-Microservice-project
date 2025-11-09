package com.practice.JobWithJPA.repository;

import com.practice.JobWithJPA.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer>{


}
