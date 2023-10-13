<template>
  <v-layout>
    <!-- PC端导航栏 -->
    <v-toolbar
      v-if="isDesktop"
      color="rgba(0, 0, 0, 0)"
      elevation="4"
      density="compact"
      class="desktop-navbar"
    >
      <v-toolbar-title>Yeolde</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-toolbar-items>

        <v-btn size="small" variant="plain" prepend-icon="mdi-home-outline" >
          <router-link to="/">Home</router-link>
        </v-btn>

        <v-menu
          open-on-hover
        >
          <template v-slot:activator="{ props }">
            <v-btn
              size="small"
              variant="plain"
              prepend-icon="mdi-menu"
              v-bind="props"
            >
              classify
            </v-btn>
          </template>

          <v-list>
            <v-list-item
              v-for="(item, index) in items"
              :key="index"
              :value="index"
            >
              <router-link :to="`/${item.title.toLowerCase()}`">{{ item.title }}</router-link>
            </v-list-item>
          </v-list>
        </v-menu>

        <v-btn size="small" variant="plain" prepend-icon="mdi-camera-outline" >
          <router-link to="/photos">Photos</router-link>
        </v-btn>

        <v-btn size="small" variant="plain" prepend-icon="mdi-label-outline" >
          <router-link to="/tags">Tags</router-link>
        </v-btn>

        <v-btn size="small" variant="plain" prepend-icon="mdi-folder-outline" >
          <router-link to="/archive">Archive</router-link>
        </v-btn>

        <v-btn size="small" variant="plain" prepend-icon="mdi-account-multiple-outline" >
          <router-link to="/about">About</router-link>
        </v-btn>

        <v-btn  @click="toggleTheme">
          <v-icon>mdi-theme-light-dark</v-icon>
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>

    <!-- 移动端导航栏 -->
    <v-navigation-drawer
      v-model="drawer"
      location="left"
      width="150"
      temporary
      class="mobile-drawer"
    >
      <v-list>
        <v-btn size="small" variant="plain" prepend-icon="mdi-home-outline" >
          <router-link to="/">Home</router-link>
        </v-btn>

        <v-btn size="small" variant="plain" prepend-icon="mdi-camera-outline">
          <router-link to="/photos">Photos</router-link>
        </v-btn>

        <v-btn size="small" variant="plain" prepend-icon="mdi-label-outline">
          <router-link to="/tags">Tags</router-link>
        </v-btn>

        <v-btn size="small" variant="plain" prepend-icon="mdi-folder-outline">
          <router-link to="/archive">Archive</router-link>
        </v-btn>
        <v-btn size="small" variant="plain" prepend-icon="mdi-account-multiple-outline" >
          <router-link to="/about">About</router-link>
        </v-btn>
      </v-list>
    </v-navigation-drawer>

    <!-- 移动端导航栏 -->
    <v-toolbar
      color="rgba(0, 0, 0, 0)"
      elevation="4"
      dense
      class="mobile-navbar"
    >
      <v-app-bar-nav-icon variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Yeolde</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn @click="toggleTheme">
        <v-icon>mdi-theme-light-dark</v-icon>
      </v-btn>
    </v-toolbar>
  </v-layout>
</template>

<script setup>
import { ref } from 'vue';
import { useTheme } from 'vuetify';

const drawer = ref(false);
const items=ref([
  {title:'Articles'},
  {title:'Essays'},
  {title:'Projects'},
]);
const open=[];
const admins=ref([
  ['Management', 'mdi-account-multiple-outline'],
  ['Settings', 'mdi-cog-outline'],
]);
const cruds=ref([
  ['Create', 'mdi-plus-circle'],
  ['Read', 'mdi-magnify'],
  ['Update', 'mdi-pencil'],
  ['Delete', 'mdi-minus-circle'],
]);
const isDesktop = window.innerWidth > 767;
const theme=useTheme();
const toggleTheme=()=>theme.global.name.value=theme.global.current.value.dark?'light':'dark';
</script>

<style scoped>
/* 媒体查询 */
@media (min-width: 768px) {
  .mobile-drawer {
    display: none!important;
  }
  .mobile-navbar {
    display: none;
  }
}

@media (max-width: 767px) {
  .mobile-drawer {
    display: block;
  }
  .desktop-navbar {
    display: none;
  }
}
</style>
