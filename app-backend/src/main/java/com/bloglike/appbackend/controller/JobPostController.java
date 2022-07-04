package com.bloglike.appbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloglike.appbackend.model.JobPost;
import com.bloglike.appbackend.repository.JobPostRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class JobPostController {
    
    @Autowired
    private JobPostRepository jobPostRepo;

    @GetMapping("/jobposts")
    public List<JobPost> fetch() {
        return jobPostRepo.findAll();
    }
}
