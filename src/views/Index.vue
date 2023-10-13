<template>
  <!--Carousel-->
  <div class="home layout">
    <v-row>
      <v-col>
        <Carousel/>
      </v-col>
    </v-row>
  </div>
<!--  <v-layout class="rounded rounded md">-->
<!--    &lt;!&ndash;left&ndash;&gt;-->
<!--    <div class="Intro">-->
<!--      <v-container>-->
<!--        <v-row >-->
<!--          <v-col cols="12">-->
<!--            <v-card outlined class="box-card" max-width="344">-->
<!--              <img :src="util.getAssetsFile('Archive/ArchiveCarousel1.jpg')"-->
<!--                   height="200px"-->
<!--                   alt=""/>-->

<!--              <v-card-title>-->
<!--                Introduction-->
<!--              </v-card-title>-->

<!--              <v-card-subtitle>-->
<!--                Yeolde-->
<!--              </v-card-subtitle>-->

<!--              <v-card-actions>-->
<!--                <v-btn-->
<!--                  color="orange-lighten-2"-->
<!--                  variant="text"-->
<!--                >-->
<!--                  Explore More-->
<!--                </v-btn>-->

<!--                <v-spacer></v-spacer>-->

<!--                <v-btn-->
<!--                  :icon="show ? 'mdi-chevron-up' : 'mdi-chevron-down'"-->
<!--                  @click="show = !show"-->
<!--                ></v-btn>-->
<!--              </v-card-actions>-->

<!--              <v-expand-transition>-->
<!--                <div v-show="show">-->
<!--                  <v-divider></v-divider>-->

<!--                  <v-card-text>-->
<!--                    //input a short intro-->
<!--                  </v-card-text>-->
<!--                </div>-->
<!--              </v-expand-transition>-->
<!--            </v-card>-->
<!--          </v-col>-->
<!--        </v-row>-->
<!--      </v-container>-->
<!--    </div>-->
<!--    &lt;!&ndash;middle&ndash;&gt;-->
<!--    <v-main class="d-flex align-center justify-center">-->
<!--      <v-container class="pa-4 text-center">-->
<!--        <v-row-->
<!--          class="fill-height"-->
<!--          align="center"-->
<!--          justify="center"-->
<!--        >-->
<!--          <template v-for="(item, i) in items" :key="i">-->
<!--            <v-col-->
<!--              cols="12"-->
<!--              md="10"-->
<!--            >-->
<!--              <v-hover v-slot="{ isHovering, props }">-->
<!--                <v-card-->
<!--                  :elevation="isHovering ? 12 : 2"-->
<!--                  :class="{ 'on-hover': isHovering }"-->
<!--                  v-bind="props"-->
<!--                >-->
<!--                  <v-img-->
<!--                    :src="item.img"-->
<!--                    height="300px"-->
<!--                    cover-->
<!--                  >-->
<!--                    <v-card-title class="text-h6 text-white d-flex flex-column">-->
<!--                      <p class="mt-4">-->
<!--                        {{ item.title }}-->
<!--                      </p>-->

<!--                      <div>-->
<!--                        <p class="ma-0 text-body-1 font-weight-bold">-->
<!--                          {{ item.text }}-->
<!--                        </p>-->
<!--                        <p class="text-caption font-weight-medium">-->
<!--                          {{ item.subtext }}-->
<!--                        </p>-->
<!--                      </div>-->
<!--                    </v-card-title>-->
<!--                    <div class="align-self-center">-->
<!--                      <v-btn-->
<!--                        variant="text"-->
<!--                        :class="{ 'show-btns': isHovering }"-->
<!--                        :color="transparent"-->
<!--                      >To Read More</v-btn>-->
<!--                    </div>-->
<!--                  </v-img>-->
<!--                </v-card>-->
<!--              </v-hover>-->
<!--            </v-col>-->
<!--          </template>-->
<!--        </v-row>-->
<!--      </v-container>-->
<!--    </v-main>-->
<!--    &lt;!&ndash;right&ndash;&gt;-->
<!--    <div class="cardsInRight">-->
<!--      <v-container>-->
<!--        <v-card-->

<!--          class="mx-auto"-->
<!--          max-width="243"-->
<!--        >-->
<!--          <v-img-->
<!--            src="https://cdn.vuetifyjs.com/images/cards/house.jpg"-->
<!--            cover-->
<!--            :aspect-ratio="16/9"-->
<!--          >-->
<!--          </v-img>-->
<!--          <v-card-title class="flex-column align-start">-->
<!--            <div class="text-h4 mb-2">-->
<!--              Welcome Home...-->
<!--            </div>-->
<!--            <div class="text-h6 font-weight-regular text-grey">-->
<!--              Monday, 12:30 PM, Mostly Sunny-->
<!--            </div>-->
<!--            <div class="d-flex align-center">-->
<!--              <v-avatar-->
<!--                size="24"-->
<!--                class="me-4"-->
<!--              >-->
<!--                <v-img-->
<!--                  src="https://cdn.vuetifyjs.com/images/weather/part-cloud-48px.png"-->
<!--                  contain-->
<!--                ></v-img>-->
<!--              </v-avatar>-->

<!--              <span class="text-body-2 text-grey">81° / 62°</span>-->
<!--            </div>-->
<!--          </v-card-title>-->

<!--          <v-divider class="mx-4"></v-divider>-->

<!--          <v-card-text class="d-flex justify-space-between">-->
<!--            <v-chip-->
<!--              prepend-icon="mdi-brightness-5"-->
<!--            >-->
<!--              Turn on lights-->
<!--            </v-chip>-->
<!--            <v-chip-->
<!--              prepend-icon="mdi-alarm-check"-->
<!--            >-->
<!--              Set alarm-->
<!--            </v-chip>-->
<!--            <v-chip-->
<!--              icon="mdi-blinds"-->
<!--            >-->
<!--              Close blinds-->
<!--            </v-chip>-->
<!--          </v-card-text>-->
<!--        </v-card>-->
<!--      </v-container>-->
<!--    </div>-->
<!--  </v-layout>-->
  <div class="text-center">
    <v-pagination
      v-model="page"
      :length="10"
      :total-visible="5"
      rounded="circle"
      prev-icon="mdi-menu-left"
      next-icon="mdi-menu-right"
    ></v-pagination>
    <v-divider></v-divider>
  </div>
</template>



<script setup lang="ts">
import Carousel from "@/components/Home/Carousel.vue";
import util from "@/utils/util";

const show=false;
const items= [
  {
    title: 'Title',
    text: `Text`,
    subtext: 'Subtext',
    img: 'https://images.unsplash.com/photo-1429514513361-8fa32282fd5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3264&q=80',
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
const page=1;

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
