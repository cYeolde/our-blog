<template>
  <v-container>
    <v-banner
      class="font-weight-bold text-medium-emphasis text-md-h5 text-lg-h4"
      stacked
    >
      <v-icon start icon="mdi-folder-outline"></v-icon>
      Archive
      <v-banner-text class="text-overline text-disabled">
        777777777</v-banner-text>
    </v-banner>
    <v-row justify="space-around">
      <v-hover v-slot="{ isHovering, props }">
        <v-card
          width="1170"
          :elevation="isHovering ? 12 : 2"
          :class="{ 'on-hover': isHovering }"
          v-bind="props"
        >
          <v-card-text>
            <v-timeline align="center">
              <v-timeline-item
                v-for="(article, i) in articles"
                :key="i"
                :dot-color="getColor(i)"
                size="small"
              >
                <template v-slot:opposite>
                  <div
                    :class="`pt-1 headline font-weight-bold text-${getColor(i)}`"
                  >
                    {{ article.uploadTime }}
                  </div>
                </template>
                <div>
                  <h1 :class="`mt-n1 headline font-weight-light mb-4 text-${getColor(i)} underline-text`"
                      @click="onTitleClick(article.id)"
                      style="cursor: pointer;"
                  >
                    {{ article.title }}
                  </h1>
                  <div :class="`text-${getColor(i)}`">
                    {{ article.description }}
                  </div>
                </div>
              </v-timeline-item>
            </v-timeline>
          </v-card-text>
        </v-card>
      </v-hover>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import {ref, onBeforeMount} from 'vue';
import router from "@/router";
import {getArchiveApi} from "@/request/api";

const articles=ref([]);

onBeforeMount(async ()=>{
  try {
    let res = await getArchiveApi();
    articles.value = res.data;
    console.log(articles.value);
  }catch (error) {
    articles.value = [];
  }
})
const onTitleClick = (id:number) => {
  router.push(`/articles/${id}`);
};
const timelineColors = ['cyan', 'green', 'pink', 'amber','orange'];
const getColor = (index: number) => {
  return timelineColors[index % timelineColors.length];
};

</script>

<style scoped>
.underline-text {
  text-decoration: underline;
}
</style>
