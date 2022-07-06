import axios from 'axios'
import { JobPost } from '../types/JobPostTypes.interface';

const JOB_POST_API_BASE_URL = 'http://localhost:8080/api/jobposts'

class JobPostService {
    getJobPosts() {
        return axios.get(JOB_POST_API_BASE_URL);
    }
    
    getJobPostById(id: string) {
        return axios.get(JOB_POST_API_BASE_URL+"/"+id);
    }

    createJobPost(input: JobPost) {
        return axios.post(JOB_POST_API_BASE_URL+"/"+"create", {
            title: input.title,
            companyName: input.companyName,
            location: input.location,
            link: input.link
        });
    }
}

export default new JobPostService()