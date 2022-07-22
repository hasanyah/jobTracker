package com.jobTrackerBackend.repository;

import java.util.List;

import com.jobTrackerBackend.model.JobPost;

public interface JobPostRepository {
    
    List<JobPost> findAll();
    JobPost findById(String id);
    List<JobPost> findByLocation(String location);
    List<JobPost> findByCompanyName(String companyName);

    void updateTitle(String id, String title);
    void updateCompanyName(String id, String companyName);
    void updateLocation(String id, String location);
    void updateLink(String id, String link);

    void save(JobPost jp);
}