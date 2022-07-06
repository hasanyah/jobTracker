<script setup lang="ts">
import { ref } from 'vue';
import JobPostService from '../services/JobPostService';
import { JobPost } from '../types/JobPostTypes.interface';
import CustomDoubleRow from './CustomDoubleRow.vue';

const jobposts = ref<JobPost[]>()
const loading = ref<Boolean>(false);
function getJobPosts() {
    loading.value = true;
    JobPostService.getJobPosts().then((response) => {
        jobposts.value = response.data;
        loading.value = false;
    })
}

function getJobPostById(id: string) {
    JobPostService.getJobPostById(id).then((response) => {
        jobposts.value = response.data;
    })
}

function addJobPost(newPost: JobPost) {
    JobPostService.createJobPost(newPost).then((response) => {
        jobposts.value.push(response.data)
    })
}

getJobPosts()
</script>

<template>
    <div class="container">
        <h1 class="text-center">Job Posts</h1>

        <div v-show="loading" class="spinner-border spinner-border-sm" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>

        <table v-show="!loading" class="table table-striped">
            <thead>
                <th>Title</th>
                <th>Company</th>
                <th>Applied</th>
                <th>Status</th>
                <th>Location</th>
                <th>URL</th>
            </thead>
            <tbody>
                <CustomDoubleRow v-for="jp in jobposts" :key="jp.id" :data="jp" />
            </tbody>
        </table>

        <button v-show="!loading" type="button" class="btn btn-primary btn-lg" data-bs-toggle="modal"
            data-bs-target="#addJobPostModal">Add new entry</button>
        <!-- Modal -->
        <div class="modal fade" id="addJobPostModal" tabindex="-1" aria-labelledby="addJobPostModalLabel"
            aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addJobPostModalLabel">Add New Job Post</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="mb-3">
                                <label for="job-title" class="col-form-label">Job title:</label>
                                <input type="text" class="form-control" id="job-title">
                            </div>
                            <div class="mb-3">
                                <label for="company-name" class="col-form-label">Company Name:</label>
                                <input type="text" class="form-control" id="company-name">
                            </div>
                            <div class="mb-3">
                                <label for="company-location" class="col-form-label">Location:</label>
                                <input type="text" class="form-control" id="company-location">
                            </div>
                            <div class="mb-3">
                                <label for="job-url" class="col-form-label">URL:</label>
                                <input type="text" class="form-control" id="job-url">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- TODO: Map integration would be cool -->
    </div>
</template>