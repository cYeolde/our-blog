<template>
  <div>
    <v-container>
      <v-banner
        class="font-weight-bold text-medium-emphasis text-md-h5 text-lg-h4"
        stacked
      >
        <v-icon start icon="mdi-note-outline"></v-icon>
        Notes List
        <v-banner-text class="text-overline text-disabled">
          777777777</v-banner-text>
      </v-banner>
    </v-container>
    <v-container class="pa-4">
      <v-row
        class="fill-height"
        align="center"
        justify="center"
      >
        <v-col
          v-for="(item, i) in displayItems"
          cols="12"
          md="10"
        >
          <v-card
            class="mx-auto"
            max-width="1000"
            color="indigo"
            variant="tonal"
          >
            <v-card-item>
              <div class="text-h6 mb-1" >
                {{articles[i+(page-1)*itemsPerPage].title}}
              </div>
              <div class="text-caption">Subtitle</div>
            </v-card-item>
            <v-card-actions>
              <router-link :to="`/articles/${articles[i + (page - 1) * itemsPerPage].id}`">
                <v-btn>
                  Read More
                </v-btn>
              </router-link>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
      <!--pagination-->
      <div class="text-center">
        <v-pagination
          v-model="page"
          :length="Math.ceil(items.length / itemsPerPage)"
          :total-visible="5"
          rounded="circle"
          prev-icon="mdi-menu-left"
          next-icon="mdi-menu-right"
        ></v-pagination>
        <v-divider></v-divider>
      </div>
    </v-container>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from "vue";
//@ts-ignore
import image from "@/assets/Image/Archive/ArchiveCarousel1.jpg";

//模拟文章数据
const articles = ref([
  { id: 1, title: '单例模式', content: '文章内容 1'},
  { id: 2, title: '文章标题 2', content: '文章内容 2' },
  { id: 3, title: '文章标题 3', content: '文章内容 3' },
]);

const items= [
  {
    title: 'Title',
    text: `Text`,
    subtext: 'Subtext',
  },
  {
    title: 'Title',
    text: `Text`,
    subtext: 'Subtext',
  },
  {
    title: 'Title',
    text: `Text`,
    subtext: 'Subtext',
  },
]
const transparent='rgba(255, 255, 255, 0)';

//分页
const page=ref(1);//当前页数
const itemsPerPage=1;//每页显示的项目数
//计算显示的项目
const displayItems=computed(() => {
  const start=(page.value - 1) * itemsPerPage;
  const end=start + itemsPerPage;
  return items.slice(start, end);
});
</script>

<style scoped>

</style>

