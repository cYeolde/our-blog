<template>
  <div>
    <header>
      <NavBar />
    </header>
    <!--挂载路由-->
    <router-view />
    <goTop />
    <Footer />
  </div>
</template>

<script setup lang="ts">
import NavBar from '@/components/SideBar/NavBar.vue'
import Footer from "@/components/SideBar/Footer.vue";
import goTop from "@/components/SideBar/goTop.vue";
</script>


