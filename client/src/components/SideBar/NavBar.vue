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
              prepend-icon="mdi-bookmark-outline"
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
              <router-link :to="`/classify/${item.title.toLowerCase()}`">{{ item.title }}</router-link>
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
          <v-icon size="x-large">
            <svg t="1697363316221" class="icon" viewBox="0 0 1029 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2191" width="128" height="128"><path d="M967.674027 718.293333A452.565333 452.565333 0 0 1 578.76736 938.666667 461.397333 461.397333 0 0 1 342.22336 85.333333a466.432 466.432 0 0 0-66.517333 239.914667 457.6 457.6 0 0 0 455.381333 460.288 449.024 449.024 0 0 0 236.586667-67.242667z m-31.146667-627.2l15.146667 28.074667 27.776 15.317333-27.776 15.317334-15.146667 28.928-15.146667-28.928-27.776-15.317334 27.776-15.317333z" fill="#FFC931" p-id="2192"></path><path d="M656.634027 162.261333l10.752 20.693334 20.693333 10.752-20.693333 11.562666-10.752 20.693334-11.605334-20.693334-19.84-11.562666 19.84-10.752z" fill="#FFC931" opacity=".8" p-id="2193"></path><path d="M841.380693 300.928l8.277334 14.890667 14.890666 8.277333-14.890666 8.277333-8.277334 15.701334-8.277333-15.701334-14.890667-8.277333 14.890667-8.277333z" fill="#FFC931" opacity=".9" p-id="2194"></path><path d="M763.940693 407.936a110.208 110.208 0 0 0-16.768 0.853333 259.413333 259.413333 0 0 0-503.466666 93.312c0 10.282667 0.853333 20.565333 1.664 30.805334a184.618667 184.618667 0 0 0-43.648-5.12 205.482667 205.482667 0 0 0 0 410.88h562.346666a265.429333 265.429333 0 0 0 0-530.730667z" fill="#CFF6FF" p-id="2195"></path></svg>
          </v-icon>
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>

    <!-- 移动端导航栏（汉堡按钮 -->
    <v-toolbar
      color="rgba(0, 0, 0, 0)"
      elevation="4"
      dense
      class="mobile-navbar"
    >
      <v-app-bar-nav-icon variant="text" @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Yeolde</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn @click="toggleTheme">
        <v-icon size="x-large">
          <svg t="1697363077025" class="icon" viewBox="0 0 1029 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1930" width="128" height="128"><path d="M967.674027 718.293333A452.565333 452.565333 0 0 1 578.76736 938.666667 461.397333 461.397333 0 0 1 342.22336 85.333333a466.432 466.432 0 0 0-66.517333 239.914667 457.6 457.6 0 0 0 455.381333 460.288 449.024 449.024 0 0 0 236.586667-67.242667z m-31.146667-627.2l15.146667 28.074667 27.776 15.317333-27.776 15.317334-15.146667 28.928-15.146667-28.928-27.776-15.317334 27.776-15.317333z" fill="#FFC931" p-id="1931"></path><path d="M656.634027 162.261333l10.752 20.693334 20.693333 10.752-20.693333 11.562666-10.752 20.693334-11.605334-20.693334-19.84-11.562666 19.84-10.752z" fill="#FFC931" opacity=".8" p-id="1932"></path><path d="M841.380693 300.928l8.277334 14.890667 14.890666 8.277333-14.890666 8.277333-8.277334 15.701334-8.277333-15.701334-14.890667-8.277333 14.890667-8.277333z" fill="#FFC931" opacity=".9" p-id="1933"></path><path d="M763.940693 407.936a110.208 110.208 0 0 0-16.768 0.853333 259.413333 259.413333 0 0 0-503.466666 93.312c0 10.282667 0.853333 20.565333 1.664 30.805334a184.618667 184.618667 0 0 0-43.648-5.12 205.482667 205.482667 0 0 0 0 410.88h562.346666a265.429333 265.429333 0 0 0 0-530.730667z" fill="#CFF6FF" p-id="1934"></path></svg>
        </v-icon>
      </v-btn>
    </v-toolbar>

    <!-- 移动端抽屉导航 -->
    <v-navigation-drawer
      v-model="drawer"
      location="left"
      width="230"
      temporary
      app
      class="indigo"
    >
      <v-list>
        <router-link to="/">
          <v-list-item>
            <v-list-item-action>
              <div>
                <v-list-item-title class="white--text">
                  <v-icon class="white--text">mdi-home-outline</v-icon>
                  Home
                </v-list-item-title>
              </div>
            </v-list-item-action>
          </v-list-item>
        </router-link>
        <!-- 分类菜单 -->
        <v-list-group value="Classify"  v-model:opened="open">
          <template v-slot:activator="{ props }">
            <v-list-item
              v-bind="props"
            >
              <v-list-item-title class="white--text">
                <v-icon class="white--text">mdi-bookmark-outline</v-icon>
                Classify
              </v-list-item-title>
            </v-list-item>
          </template>
          <v-list-item
            v-for="([title, icon], i) in Classify"
            :key="i"
            :title="title"
            :prepend-icon="icon"
            :value="title"
            router :to="`/classify/${title.toLowerCase()}`"
          ></v-list-item>
        </v-list-group>

        <v-list-item v-for="link in links" :key="link.text" router :to="link.route">
          <v-list-item-action>
            <div>
              <v-list-item-title class="white--text">
                <v-icon class="white--text">{{link.icon}}</v-icon>
                {{link.text}}
              </v-list-item-title>
            </div>
          </v-list-item-action>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-layout>
</template>

<script setup>
import { ref } from 'vue';
import { useTheme } from 'vuetify';

//get后端的分类名放到NavBar里
const Classify=ref([
  ['Notes', 'mdi-note-outline'],
  ['Projects', 'mdi-clipboard-outline'],
]);

const items=ref([
  {title:'Notes'},
  {title:'Projects'},
]);

const drawer = ref(false);
const open=[true];
const links=ref([
  {icon:'mdi-camera-outline',text:'Photos',route:'/photos'},
  {icon:'mdi-label-outline',text:'Tags',route:'/tags'},
  {icon:'mdi-folder-outline',text:'Archive',route:'/archive'},
  {icon:'mdi-dots-horizontal',text:'About',route:'/about'},
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
