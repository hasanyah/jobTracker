package com.jobTrackerBackend.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("jobpost")
@Builder
public class JobPost {
    
    @Id
    private String id;

    private String title;
    private String companyName;
    private String location;
    private String link;
    private String status;
    
    @DateTimeFormat(iso = ISO.DATE_TIME) 
    private Date appliedDate; 
}
