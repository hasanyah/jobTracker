<script setup lang="ts">
import { ref } from 'vue';
import JobPostService from '../services/JobPostService';
import { JobPost } from '../types/JobPostTypes.interface'
import moment from 'moment'

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

function toDays(date: string): string {
    if (!date)
        return "N/A"

    let unit : moment.unitOfTime.Diff;
    unit = "day";
    let now = moment()
    let then = moment(date)
    let diff = now.diff(then, unit )

    if (diff < 1) {
        unit = "hour"
        diff = now.diff(then, unit)
    }
    if (diff < 1) {
        unit = "minute"
        diff = now.diff(then, unit)
    }
    if (diff < 1) {
        unit = "second"
        diff = now.diff(then, unit)
    }

    if (diff > 1)
        unit += 's'

    return diff + " " + unit + " ago"
}

getJobPosts()
</script>

<script lang="ts">
import { library } from '@fortawesome/fontawesome-svg-core';
import { faUpRightFromSquare } from '@fortawesome/free-solid-svg-icons';
library.add(faUpRightFromSquare)
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
            <tr v-for="jp in jobposts" :key="jp.id">
                <td>{{ jp.title }}</td>
                <td>{{ jp.companyName }}</td>
                <td>{{ toDays(jp.appliedDate) }}</td>
                <td>{{ jp.status }}</td>
                <td>{{ jp.location }}</td>
                <td>
                    <a class="btn btn-labeled" target="_blank" :href="jp.link">
                    
                        <!-- @click="getJobPostById(jp.id)" -->
                            <span class="btn-label">
                                <font-awesome-icon :icon="['fas', 'up-right-from-square']" />
                            </span>
                    
                        </a>
                </td>
            </tr>
        </tbody>
    </table>

    <!-- TODO: Map integration would be cool -->
</div>
</template>