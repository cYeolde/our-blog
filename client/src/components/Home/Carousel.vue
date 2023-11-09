<template>
  <div class="Carousel">
    <v-carousel
      cycle
      height="300"
      hide-delimiter-background
      show-arrows="hover"
    >
      <v-carousel-item
        v-for="(item, i) in items"
        :key="i"
        :src="item.src"
        cover
      >
      </v-carousel-item>
    </v-carousel>
  </div>
</template>

<script setup lang="ts">
import util from '@/utils/util';
const items = [
  {
    src: util.getAssetsFile('Home/Carousel1.jpg'),
  },
  {
    src: util.getAssetsFile('Home/Carousel2.jpg'),
  },
  {
    src: util.getAssetsFile('Home/Carousel3.jpg'),
  },
  {
    src: util.getAssetsFile('Home/Carousel4.jpg'),
  },
]
</script>

<style scoped>

</style>
