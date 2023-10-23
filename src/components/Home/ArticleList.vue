<template>
  <v-container class="pa-4 text-center">
    <v-row
      class="fill-height"
      align="center"
      justify="center"
    >
      <v-col
        v-for="(item, i) in displayItems"
        cols="12"
        md="10"
      >
        <v-hover v-slot="{ isHovering, props }">
          <v-card
            :elevation="isHovering ? 12 : 2"
            :class="{ 'on-hover': isHovering }"
            v-bind="props"
          >
            <v-img
              :src="item.img"
              height="300px"
              cover
            >
              <v-card-title class="text-h6 text-white d-flex flex-column">
                <p class="mt-4">
                  {{ item.title }}
                </p>
                <div>
                  <p class="ma-0 text-body-1 font-weight-bold">
                    {{ item.text }}
                  </p>
                  <p class="text-caption font-weight-medium">
                    {{ item.subtext }}
                  </p>
                </div>
              </v-card-title>
              <div class="align-self-center">
                <v-btn
                  variant="text"
                  :class="{ 'show-btns': isHovering }"
                  :color="transparent"
                >To Read More</v-btn>
              </div>
            </v-img>
          </v-card>
        </v-hover>
      </v-col>
      <!--      </template>-->
    </v-row>
    <!--pagination-->
    <div class="text-center">
      <v-pagination
        v-model="page"
        :length="Math.ceil(items.length / itemsPerPage)"
        :total-visible="5"
        rounded="circle"
        prev-icon="mdi-menu-left"
        next-icon="mdi-menu-right"
      ></v-pagination>
      <v-divider></v-divider>
    </div>
  </v-container>
</template>

<script setup lang="ts">
import { ref, computed } from "vue";
//@ts-ignore
import image from "@/assets/Image/Archive/ArchiveCarousel1.jpg";
const show=false;
const items= [
  {
    title: 'Title',
    text: `Text`,
    subtext: 'Subtext',
    img: image,
  },
  {
    title: 'Title',
    text: `Text`,
    subtext: 'Subtext',
    img: 'https://images.unsplash.com/photo-1498038432885-c6f3f1b912ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80',
  },
  {
    title: 'Title',
    text: `Text`,
    subtext: 'Subtext',
    img: 'https://images.unsplash.com/photo-1542320868-f4d80389e1c4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3750&q=80',
  },
]
const transparent='rgba(255, 255, 255, 0)';

//分页
const page=ref(1);//当前页数
const itemsPerPage=2;//每页显示的项目数
//计算显示的项目
const displayItems=computed(() => {
  const start=(page.value - 1) * itemsPerPage;
  const end=start + itemsPerPage;
  return items.slice(start, end);
});


</script>

<style scoped>
#cardsInRight v-card {
  transition: opacity .4s ease-in-out;
}

.v-card:not(.on-hover) {
  opacity: 0.6;
}

.show-btns {
  color: rgba(255, 255, 255, 1) !important;
}
</style>
