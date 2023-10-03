<script setup lang="ts">
import TagsBanner from "@/components/Tags/TagsBanner.vue";
import TagsCard from "@/components/Tags/TagsCard.vue";
import util from "@/utils/util";
</script>

<template>
 <TagsBanner />
  <TagsCard />
  <img :src="util.getAssetsFile('Archive/ArchiveCarousel1.jpg')" alt="">
</template>

<style scoped>

</style>
