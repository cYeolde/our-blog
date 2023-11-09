<template>
  <v-container class="pa-4 text-center">
    <v-row
      class="fill-height"
      align="center"
      justify="center"
    >
      <v-col
        v-for="(item,i) in items"
        :key="item.id"
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
              :src="'/api'+item['coverUrl']"
              height="300px"
              cover
            >
              <v-card-title class="text-h6  d-flex flex-column">
                <p class="mt-4">
                  {{ item.title}}
                </p>
                <div>
                  <p class="ma-0 text-body-1 font-weight-bold">
                    {{ item.description }}
                  </p>
                </div>
              </v-card-title>
              <router-link to="/classify/notes">
              <v-chip
                variant="text"
                style="cursor: pointer;"
              >
                <v-icon start icon="mdi-bookmark-outline"></v-icon>
                Notes
              </v-chip>
              </router-link>
              <router-link :to="`/tags/${items[i].label}`">
              <v-chip
                variant="text"
                style="cursor: pointer;"
              >
                <v-icon start icon="mdi-label-outline"></v-icon>
                {{ item.label }}
              </v-chip>
              </router-link>
              <div class="align-self-center">
                <router-link :to="`/articles/${items[i].id}`">
                  <v-btn
                    variant="text"
                    :class="{ 'show-btns': isHovering }"
                  >
                    Read More
                  </v-btn>
                </router-link>
              </div>
            </v-img>
          </v-card>
        </v-hover>
      </v-col>
    </v-row>

    <!--pagination-->
    <div class="text-center" >
      <v-pagination
        v-model="page"
        :length="totalPages"
        rounded="circle"
        prev-icon="mdi-menu-left"
        next-icon="mdi-menu-right"
        @click="getArticleList(page,6)"
      ></v-pagination>
      <v-divider></v-divider>
    </div>
  </v-container>
</template>

<script setup lang="ts">
import { ref, onMounted} from "vue";
import {getArticleListApi} from "@/request/api";

const transparent='rgba(255, 255, 255, 0)';
//分页
const page=ref(1);//当前页数  pageNum
const currentPage=ref(1);//当前页数  pageNum
const itemsPerPage=ref(6);//每页显示的项目数  pageSize
const totalPages=ref(0);//总页数 pages
const totalItems=ref(0);//总文章数 total
const items=ref([]);//文章列表

const getArticleList=async (pageNum:number,pageSize:number) => {
  let res = await getArticleListApi(pageNum,pageSize);
  console.log(pageNum,pageSize);
  items.value=res.data.records;
  currentPage.value=res.data.current;
  page.value=currentPage.value;
  itemsPerPage.value=res.data.size;
  totalPages.value=res.data.pages;
  totalItems.value=res.data.total;
  console.log(res.data);
}

onMounted(async () => {
  await getArticleList(page.value,itemsPerPage.value);
})
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
