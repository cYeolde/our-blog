<template>
  <!--Carousel-->
  <div class="Carousel">
    <Carousel />
  </div>

  <!--Content-->
    <div>
      <v-row>
        <v-col cols="12" sm="9">
          <ArticleList />
        </v-col>
        <v-col cols="12" sm="3">
          <v-row >
            <IntroCard />
          </v-row>
          <v-row>
            <TagCloud />
          </v-row>
        </v-col>
      </v-row>
    </div>
</template>

<script setup lang="ts">
import Carousel from "@/components/Home/Carousel.vue";
import ArticleList from "@/components/Home/ArticleList.vue";
import IntroCard from "@/components/Home/IntroCard.vue";
import TagCloud from "@/components/Home/TagCloud.vue";
</script>

<style scoped>

</style>
