<template>
    <el-carousel :interval="4000" type="card" height="carouselHeight">
      <el-carousel-item>
        <img :src="util.getAssetsFile('Archive/ArchiveCarousel1.jpg')" width="1000" height="400" alt=""/>
      </el-carousel-item>
      <el-carousel-item>
        <img :src="util.getAssetsFile('Archive/ArchiveCarousel2.jpg')" width="1000" height="400" alt=""/>
      </el-carousel-item>
      <el-carousel-item>
        <img :src="util.getAssetsFile('Archive/ArchiveCarousel3.jpg')" width="1000" height="400" alt=""/>
      </el-carousel-item>
    </el-carousel>
  <ArchiveBanner />
  <ArchiveCard />
</template>

<script setup lang="ts">
import ArchiveBanner from "@/components/Archive/ArchiveBanner.vue";
import ArchiveCard from "@/components/Archive/ArchiveCard.vue";
import util from "@/utils/util";
import { ref,onMounted,onBeforeUnmount } from "vue";
//创建响应式变量存储轮播图高度
const carouselHeight = ref("260px");

//窗口变化时，重新计算轮播图高度
const updateCarouselHeight = () => {
  const width = document.body.clientWidth;
  if (width < 768) {
    carouselHeight.value = "200px";//小屏幕
  }
  else if(width<1024){
    carouselHeight.value = "260px";//中屏幕
  }
  else {
    carouselHeight.value = "400px";//大屏幕
  }
};

//在组件挂载时添加窗口大小监听器
onMounted(() => {
  window.addEventListener("resize", updateCarouselHeight);
  updateCarouselHeight();
});

//在组件卸载时移除窗口大小监听器
onBeforeUnmount(() => {
  window.removeEventListener("resize", updateCarouselHeight);
});
</script>

<style scoped>

</style>
<!--<template>-->
<!--  <el-carousel :interval="4000" type="card" height="260px">-->
<!--    <el-carousel-item>-->
<!--      <img :src="util.getAssetsFile('Archive/ArchiveCarousel1.jpg')" width="1000" height="400" alt=""/>-->
<!--    </el-carousel-item>-->
<!--    <el-carousel-item>-->
<!--      <img :src="util.getAssetsFile('Archive/ArchiveCarousel2.jpg')" width="1000" height="400" alt=""/>-->
<!--    </el-carousel-item>-->
<!--    <el-carousel-item>-->
<!--      <img :src="util.getAssetsFile('Archive/ArchiveCarousel3.jpg')" width="1000" height="400" alt=""/>-->
<!--    </el-carousel-item>-->
<!--  </el-carousel>-->
<!--  <ArchiveBanner />-->
<!--  <ArchiveCard />-->
<!--</template>-->

<!--<script setup lang="ts">-->
<!--import ArchiveBanner from "@/components/Archive/ArchiveBanner.vue";-->
<!--import ArchiveCard from "@/components/Archive/ArchiveCard.vue";-->
<!--import util from "@/utils/util";-->
<!--</script>-->

<!--<style scoped>-->
<!--.el-carousel__item h3 {-->
<!--  color: #d3dce6;-->
<!--  opacity: 0.75;-->
<!--  line-height: 200px;-->
<!--  margin: 0;-->
<!--  text-align: center;-->
<!--}-->

<!--.el-carousel__item:nth-child(2n) {-->
<!--  background-color: #99a9bf;-->
<!--}-->

<!--.el-carousel__item:nth-child(2n + 1) {-->
<!--  background-color: #d3dce6;-->
<!--}-->
<!--</style>-->
