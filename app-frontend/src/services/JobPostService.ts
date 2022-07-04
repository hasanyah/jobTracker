import axios from 'axios'

const JOB_POST_API_BASE_URL = 'http://localhost:8080/api/jobposts'

class JobPostService {
    getJobPosts() {
        return axios.get(JOB_POST_API_BASE_URL);
    }
    
    getJobPostById(id: string) {
        return axios.get(JOB_POST_API_BASE_URL+"/"+id);
    }
}

export default new JobPostService()