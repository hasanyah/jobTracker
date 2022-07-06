<script setup lang="ts">
import { ref } from 'vue';
import JobPostService from '../services/JobPostService';
import { JobPost } from '../types/JobPostTypes.interface';
import CustomDoubleRow from './CustomDoubleRow.vue';

const jobposts = ref<JobPost[]>()

function getJobPosts() {
    JobPostService.getJobPosts().then((response) => {
        jobposts.value = response.data;
    })
}

function getJobPostById(id: string) {
    JobPostService.getJobPostById(id).then((response) => {
        jobposts.value = response.data;
    })
}

getJobPosts()
</script>

<template>
<div class="container">
    <h1 class="text-center">Job Posts</h1>
    <table class="table table-striped">
        <thead>
            <th>Title</th>
            <th>Company</th>
            <th>Applied</th>
            <th>Status</th>
            <th>Location</th>
            <th>URL</th>
        </thead>
        <tbody>
            <CustomDoubleRow v-for="jp in jobposts" :key="jp.id" :data="jp"/>
        </tbody>
    </table>

    <!-- TODO: Map integration would be cool -->
</div>
</template>