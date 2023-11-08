<template>
  <div class="Carousel">
    <v-carousel
      cycle
      height="400"
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
import Carousel1 from '@/assets/Image/Home/Carousel1.jpg';
import Carousel2 from '@/assets/Image/Home/Carousel2.jpg';
import Carousel3 from '@/assets/Image/Home/Carousel3.jpg';
import Carousel4 from '@/assets/Image/Home/Carousel4.jpg';

const items = [
  {
    src: Carousel1,
  },
  {
    src: Carousel2,
  },
  {
    src: Carousel3,
  },
  {
    src: Carousel4,
  },
]
</script>

<style scoped>

</style>
