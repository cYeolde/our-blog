<template>
  <v-container>
    <v-banner
      class="font-weight-bold text-medium-emphasis text-h5"
      stacked
    >
      <v-icon start icon="mdi-label-outline"></v-icon>
      Tags
      <v-banner-text class="text-overline text-disabled">
        1111
      </v-banner-text>
    </v-banner>
  </v-container>
  <v-container class="pa-4 text-center">
    <v-card class="mx-auto" variant="outlined">
      <v-card-text>
        <h2 class="text-h6 mb-2">Tag Cloud</h2>
        <div class="d-flex justify-center">
          <v-chip-group>
            <router-link
              v-for="(tag,i) in tags"
              :key="tag"
              :to="`/tags/${tags[i]}`"
            >
              <v-chip variant="text">{{tags[i]}}</v-chip>
            </router-link>
          </v-chip-group>
        </div>
      </v-card-text>
      <v-divider></v-divider>
    </v-card>
  </v-container>
</template>


<script setup lang="ts">
import {ref, onBeforeMount} from 'vue';
import {getTagApi} from "@/request/api";
const tags= ref([]);

onBeforeMount(async() => {
  let res = await getTagApi();
  tags.value = res.data;
  console.log(tags.value);
})
</script>

<style scoped>

</style>
