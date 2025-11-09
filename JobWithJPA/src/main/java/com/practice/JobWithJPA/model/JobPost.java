package com.practice.JobWithJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {
    @Id
    private int jobId;
    private String jobProfile;
    private String jobDesc;
    private int reqExp;
    private List<String> skills;

}
