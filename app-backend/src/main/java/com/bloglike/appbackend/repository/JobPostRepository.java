package com.bloglike.appbackend.repository;

import java.util.List;

import com.bloglike.appbackend.model.JobPost;

public interface JobPostRepository {
    
    List<JobPost> findAll();
    List<JobPost> findByLocation(String location);
    List<JobPost> findByCompanyName(String companyName);

    void updateTitle(String id, String title);
    void updateCompanyName(String id, String companyName);
    void updateLocation(String id, String location);
    void updateLink(String id, String link);

    void save(JobPost jp);
}