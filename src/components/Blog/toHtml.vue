<template>
  <v-divider></v-divider>
  <v-card class="mx-auto" max-width="1200">
    <v-card-title class="text-h5 text-center">Markdown 文档预览</v-card-title>
    <v-card-text>
      <!-- 生成目录结构 -->
      <v-md-editor v-model="markdownTxt" height="500px" @copy-code-success="handleCopyCodeSuccess" />
      <v-md-preview  :text="markdownTxt" ></v-md-preview>
    </v-card-text>
  </v-card>
</template>

<script setup lang="ts">
import markdownTxt from "@/assets/Articles/单例模式.md?raw";
import { onMounted, onBeforeUnmount } from "vue";

const handleCopyCodeSuccess = (code:String) => {
  console.log(code);
};

</script>
