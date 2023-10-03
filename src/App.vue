<template>
  <div>
    <header>
      <NavBar />
    </header>
    <router-view />
    <goTop />
    <Footer />

  </div>
</template>

<script  lang="ts">
import NavBar from '@/components/NavBar.vue'
import Footer from "@/components/Footer.vue";
import goTop from "@/components/goTop.vue";

export default {
  name: 'App',
  components: {
    NavBar,
    Footer,
    goTop,
  },
  data: () => ({

  }),
  /*setup(){
    const theme = ref('light')
    const changeTheme = () => theme.value = theme.value === 'light' ? 'dark' : 'light'
    return {
      theme,
      changeTheme,
    }
  }
   */
};

</script>


