<!--文章组件，接受并显示来自动态路由的文章ID-->
<template>
  <v-divider></v-divider>
  <v-card class="mx-auto" max-width="1200">
    <v-card-title class="text-h5 text-center">{{articleTitle}}</v-card-title>
    <v-card-text>
      <v-md-editor  v-model="articleContent" height="500px" @copy-code-success="handleCopyCodeSuccess" />
      <v-md-preview  :text="articleContent" ></v-md-preview>
    </v-card-text>
  </v-card>
  <!--  <div id="gitalk-container"></div>-->
</template>

<script setup lang="ts">
import {onBeforeMount, ref,computed,watch} from "vue";
import { useRoute } from "vue-router";
//@ts-ignore
import markdownTxt from "@/assets/Articles/3.md?raw";

const handleCopyCodeSuccess = (code:String) => {
  console.log(code);
};

const articleTitle = ref("");
const articleContent = ref("");

//获取文章ID加载文章内容
const router = useRoute();

onBeforeMount(() => {
  const articleId = router.params.id;

  const articles = [
    { id: 1, title: '单例模式 ', content: markdownTxt },
    { id: 2, title: '学习笔记 1', content: '文章内容 1' },
    { id: 3, title: '学习笔记 2', content: '文章内容 2' },
  ];

  // 查找匹配的文章
  const matchedArticle = articles.find((article) => article.id === Number(articleId));

  if (matchedArticle) {
    articleTitle.value = matchedArticle.title;
    articleContent.value = matchedArticle.content;
  } else {
    articleTitle.value = '文章不存在';
    articleContent.value = '抱歉，该文章不存在。';
  }

  //博文主题
  // const isDarkTheme=computed(()=>theme.global.current.value.dark);
  // watch(isDarkTheme,(newVal)=>{
  //   if(newVal){
  //     document.body.classList.add('dark');
  //   }
  //   else{
  //     document.body.classList.remove('dark');
  //   }
  // })
});

</script>

<style scoped>

</style>
