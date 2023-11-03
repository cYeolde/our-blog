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
                :dot-color="article.color"
                size="small"
              >
                <template v-slot:opposite>
                  <div
                    :class="`pt-1 headline font-weight-bold text-${article.color}`"
                  >
                    {{ article.date }}
                  </div>
                </template>
                <div>
                  <h1 :class="`mt-n1 headline font-weight-light mb-4 text-${article.color} underline-text`"
                      @click="onTitleClick(article.id)"
                      style="cursor: pointer;"
                  >
                    {{ article.title }}
                  </h1>
                  <div>
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
import { ref, onMounted } from 'vue';
import router from "@/router";
const articles=[
  {
    id:7,
    color: 'cyan',
    date: '2019/12/05',
    title:'title1',
    description:'description1',
    coverUrl:'/api/cover/1'
  },
  {
    id:8,
    color: 'green',
    date: '2019/12/23',
    title:'title2',
    description:'description2',
    coverUrl:'/api/cover/2'
  },
  {
    id:9,
    color: 'pink',
    date: '2020/5/24',
    title:'title3',
    description:'description3',
    coverUrl:'/api/cover/3'
  },
  {
    id:10,
    color: 'amber',
    date: '2021/1/22',
    title:'title4',
    description:'description4',
    coverUrl:'/api/cover/4'
  },
  {
    id:11,
    color: 'orange',
    date: '2023/7/11',
    title: 'title5',
    description: 'description5',
    coverUrl: '/api/cover/5'
  }];


const onTitleClick = (id:number) => {
  router.push(`/articles/${id}`);
};
</script>

<style scoped>
.underline-text {
  text-decoration: underline;
}
</style>
