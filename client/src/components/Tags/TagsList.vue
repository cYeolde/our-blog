<template>
  <v-container>
    <v-banner
      class="font-weight-bold text-medium-emphasis text-md-h5 text-lg-h4"
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
              v-for="tag in tags"
              :key="tag.tagName"
              :to="`/tags/${tag.tagName}`"
            >
              <v-chip variant="text">{{ tag.tagName }}</v-chip>
            </router-link>
          </v-chip-group>
        </div>
      </v-card-text>
      <v-divider></v-divider>
    </v-card>
  </v-container>
</template>


<script setup lang="ts">
import { ref, onMounted } from 'vue';

const tags = ref([
  { tagName: 'tag1'},
  { tagName: 'tag2'},
  { tagName: 'tag3'},
]);

onMounted(() => {
  // 在这里可以使用异步请求获取标签列表
});

</script>

<style scoped>

</style>
