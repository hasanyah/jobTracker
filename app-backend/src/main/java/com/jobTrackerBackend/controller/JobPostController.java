package com.jobTrackerBackend.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobTrackerBackend.model.JobPost;
import com.jobTrackerBackend.repository.JobPostRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class JobPostController {
    
    @Autowired
    private JobPostRepository jobPostRepo;

    @GetMapping("/jobposts")
    public List<JobPost> fetch() {
        return jobPostRepo.findAll();
    }

    @GetMapping("/jobposts/{id}")
    public JobPost fetchById(@PathVariable("id") String id) {
        return jobPostRepo.findById(id);
    }

    @PostMapping("/jobposts/create")
    public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jp) {
        try {
            JobPost newJp = JobPost.builder()
                            .title(jp.getTitle())
                            .companyName(jp.getCompanyName())
                            .location(jp.getLocation())
                            .link(jp.getLink())
                            .appliedDate(new Date())
                            .status("Pending")
                            .build();

            jobPostRepo.save(newJp);
            return new ResponseEntity<>(newJp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
