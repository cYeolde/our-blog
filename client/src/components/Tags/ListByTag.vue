<template>
  <v-container class="pa-4 text-center">
    <v-banner
      class="text-medium-emphasis text-md-h5 text-lg-h5 text-disabled"
      stacked
    >
      <v-icon start icon="mdi-label-outline"></v-icon>
      标签{{ tagName }}下的文章
    </v-banner>
  </v-container>
  <v-container>
    <v-row
      class="fill-height"
      align="center"
      justify="center"
    >
      <v-col
        v-for="(article,i) in articles"
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
              {{article.title}}
            </div>
            <div class="text-caption">
              {{article.description}}
            </div>
          </v-card-item>
          <v-card-actions>
            <router-link :to="`/articles/${articles[i].id}`">
              <v-btn>
                Read More
              </v-btn>
            </router-link>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>

    <!--pagination-->
    <div class="text-center" >
      <v-pagination
        v-model="page"
        :length="totalPages"
        rounded="circle"
        prev-icon="mdi-menu-left"
        next-icon="mdi-menu-right"
        @click="getArticleList(articleTag,page)"
      ></v-pagination>
      <v-divider></v-divider>
    </div>
  </v-container>
</template>

<script setup lang="ts">
import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";
import {getListByTagApi} from "@/request/api";
const router = useRoute();
const tagName = router.params.tagName;//从动态路由中获取标签名

const page=ref(1);
const pageNum=ref(1);
const totalPages=ref(0);
const articleTag=ref('');
const articles=ref([]);

const getArticleList = async (TagName:string,pageNum:number) => {
  articleTag.value = String(tagName);
  let res = await getListByTagApi(articleTag.value,pageNum);
  articles.value = res.data.records;
  totalPages.value = res.data.pages;
};

onMounted(async () => {
  await getArticleList(articleTag.value,pageNum.value)
})


</script>

<style scoped>

</style>
