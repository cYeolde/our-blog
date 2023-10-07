<template>
  <v-toolbar
    color="rgba(0, 0, 0, 0)"
    elevation="4"
    density="compact"
  >

    <v-toolbar-title>CCCCCC</v-toolbar-title>

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

      <v-btn size="small" variant="plain" icon="mdi-home" @click="toggleTheme"></v-btn>

    </v-toolbar-items>
  </v-toolbar>
</template>

<script setup lang="ts">
import { useTheme} from "vuetify";
import { ref } from 'vue';

const items=ref([
  {title:'Articles'},
  {title:'Essays'},
  {title:'Projects'},
]);
const theme=useTheme();
const toggleTheme=()=>theme.global.name.value=theme.global.current.value.dark?'light':'dark';

</script>

<style scoped>
</style>
