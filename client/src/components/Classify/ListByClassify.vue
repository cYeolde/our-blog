<template>
  <div>
    <v-container class="pa-4 text-center">
      <v-banner
        class="text-medium-emphasis text-h5 text-disabled"
        stacked
      >
        <v-icon start icon="mdi-label-outline"></v-icon>
        分类Notes下的文章
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
import {useRoute} from "vue-router";

const router = useRoute();
const classifyName = router.params.classifyName;//从动态路由中获取分类名

//模拟文章数据
const articles = ref([
  { id: 7, title: 'datetime类型数据合理设置', content: '文章内容 1'},
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

