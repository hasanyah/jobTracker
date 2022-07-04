<script setup lang="ts">
import { ref } from 'vue';
import JobPostService from '../services/JobPostService';
import { JobPost } from '../types/JobPostTypes.interface'

const jobposts = ref<JobPost[]>()

function getJobPosts() {
    JobPostService.getJobPosts().then((response) => {
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
            <th>ID</th>
            <th>Title</th>
            <th>Company</th>
            <th>Location</th>
            <th>URL</th>
        </thead>
        <tbody>
            <tr v-for="jp in jobposts" :key="jp.id">
                <td>{{ jp.id }}</td>
                <td>{{ jp.title }}</td>
                <td>{{ jp.companyName }}</td>
                <td>{{ jp.location }}</td>
                <td>{{ jp.link }}</td>
            </tr>
        </tbody>
    </table>
</div>
</template>