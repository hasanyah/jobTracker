package com.bloglike.appbackend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.bloglike.appbackend.model.JobPost;
import com.mongodb.client.result.UpdateResult;

@Component
public class JobPostRepositoryImpl implements JobPostRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;

    public List<JobPost> findAll() {
        Query query = new Query();
        List<JobPost> jobs = mongoTemplate.find(query, JobPost.class);
        return jobs;
    }

    @Override
    public List<JobPost> findByLocation(String location) {
        Query query = new Query();
        query.addCriteria(Criteria.where("location").is(location));
        List<JobPost> jobs = mongoTemplate.find(query, JobPost.class);
        return jobs;
    }

    @Override
    public List<JobPost> findByCompanyName(String companyName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("companyname").is(companyName));
        List<JobPost> jobs = mongoTemplate.find(query, JobPost.class);
        return jobs;
    }

    @Override
    public void updateTitle(String id, String title) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("title", title);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, JobPost.class);

        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");
    }

    @Override
    public void updateCompanyName(String id, String companyName) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("companyname", companyName);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, JobPost.class);

        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");
    }

    @Override
    public void updateLocation(String id, String location) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("location", location);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, JobPost.class);

        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");
    }

    @Override
    public void updateLink(String id, String link) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("link", link);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, JobPost.class);

        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");
    }

    @Override
    public void save(JobPost jp) {
        mongoTemplate.save(jp);
    }
}
