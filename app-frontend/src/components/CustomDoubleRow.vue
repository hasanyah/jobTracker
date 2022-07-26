<script setup lang="ts">
import moment from 'moment'
import { JobPost } from '../types/JobPostTypes.interface';
import JobDetailBox from './JobDetailBox.vue'

const props = defineProps<{
    data: JobPost
}>();

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

function dateToReadableFormat(date: string): string {
    return moment(date).format('MMMM d, YYYY - HH:mm');
}

</script>
<script lang="ts">
import { library } from '@fortawesome/fontawesome-svg-core';
import { faUpRightFromSquare } from '@fortawesome/free-solid-svg-icons';
library.add(faUpRightFromSquare)
</script>

<template>
<tr data-bs-toggle="collapse" :data-bs-target="'#collapsingJobPost'+props.data.id" aria-expanded="false" :aria-controls="'collapsingJobPost'+props.data.id">
    <td>{{ props.data.title }}</td>
    <td>{{ props.data.companyName }}</td>
    <td data-bs-toggle="tooltip" data-bs-placement="top" :title="dateToReadableFormat(props.data.appliedDate)">{{ toDays(props.data.appliedDate) }}</td>
    <td>{{ props.data.status }}</td>
    <td>{{ props.data.location }}</td>
    <td><a class="btn btn-labeled" target="_blank" :href="props.data.link">
        <span class="btn-label">
            <font-awesome-icon :icon="['fas', 'up-right-from-square']" />
        </span></a>
    </td>
</tr>
<tr class="collapse" :id="'collapsingJobPost'+props.data.id">
    <td colspan="6">
        <JobDetailBox />
    </td>
</tr>
</template>