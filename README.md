# Goal

To provide a simple tool for tracking job applications. Researches suggest that it takes about a hundred applications for a recent graduate to land a job, and this tool should help them the process of those applications.

# Architecture

The backend is run with Spring Boot framework with MongoDB as the database. It is run via a docker container, which is the desired work method for all services in this project.

Frontend is a VueJS application, which communicates via the backend service REST API. 
