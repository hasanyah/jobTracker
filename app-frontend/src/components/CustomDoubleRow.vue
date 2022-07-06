<script setup lang="ts">
import moment from 'moment'
import JobDetailBox from './JobDetailBox.vue'

const props = defineProps({
    data: Object
});

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

</script>
<script lang="ts">
import { library } from '@fortawesome/fontawesome-svg-core';
import { faUpRightFromSquare } from '@fortawesome/free-solid-svg-icons';
library.add(faUpRightFromSquare)
</script>

<template>
<tr data-bs-toggle="collapse" :data-bs-target="'#collapsingJobPost'+data.id" aria-expanded="false" :aria-controls="'collapsingJobPost'+data.id">
    <td>{{ data.title }}</td>
    <td>{{ data.companyName }}</td>
    <td>{{ toDays(data.appliedDate) }}</td>
    <td>{{ data.status }}</td>
    <td>{{ data.location }}</td>
    <td><a class="btn btn-labeled" target="_blank" :href="data.link">
        <span class="btn-label">
            <font-awesome-icon :icon="['fas', 'up-right-from-square']" />
        </span></a>
    </td>
</tr>
<tr class="collapse" :id="'collapsingJobPost'+data.id">
    <td colspan="6">
        <JobDetailBox />
    </td>
</tr>
</template>