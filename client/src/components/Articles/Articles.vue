<!--文章组件，接受并显示来自动态路由的文章ID-->
<template>
  <v-container class="pa-4 text-center">
    <v-banner
      class="text-medium-emphasis text-h5 font-weight-black"
      stacked
    >
      {{ articleTitle }}

      <v-banner-text
        class="text-overline"
      >
        <router-link :to="`/tags/${articleTag}`">
          <v-icon start icon="mdi-label-outline"></v-icon>
          {{articleTag}}
        </router-link>
      </v-banner-text>
      <v-banner-text
        class="text-overline"
      >
          {{articleTime}}
      </v-banner-text>
    </v-banner>
  </v-container>
  <v-card class="mx-auto" max-width="1200" variant="text">
    <v-card-text>
      <v-md-editor  v-model="articleContent" height="500px" @copy-code-success="handleCopyCodeSuccess" />
      <v-md-preview  :text="articleContent" ></v-md-preview>
    </v-card-text>
  </v-card>
</template>

<script setup lang="ts">
import {onBeforeMount, ref} from "vue";
import {useRoute} from "vue-router";
import {getArticleDetailApi} from "@/request/api";

const handleCopyCodeSuccess = (code:String) => {
  console.log(code);
};

const articleTitle = ref("");
const articleContent = ref("");
const articleTag = ref("");
const articleTime = ref("");
const articlePath = ref("");
const articleId = ref(0);
const article = ref({});
//获取文章ID加载文章内容
const router = useRoute();

onBeforeMount(async ()=>
{
  try {
    articleId.value = Number(router.params.id);
    let res = await getArticleDetailApi(articleId.value);
    article.value = res.data;
    articleTitle.value = res.data.title;//文章标题
    articleTag.value = res.data.label;//文章标签
    articleTime.value = res.data.uploadTime;//文章时间
    articlePath.value = res.data.filePath;
    const apiPath = '/api'+`${articlePath.value}`;
    //Fetch
    const response=await fetch(apiPath);
    const markdownTxt=await response.text();
    articleContent.value = markdownTxt;
  }catch (error) {
    articleTitle.value = '文章标题不存在';
    articleContent.value = '文章内容不存在';
  }
})

</script>

<style scoped>

</style>
