<template>
  <v-container>
    <v-card
      class="mx-auto"
      max-width="344"
    >
      <v-card-title class="text-h4 text--primary">My Profile</v-card-title>
      <v-card-subtitle>这里写啥</v-card-subtitle>
      <div class="d-flex d-flex align-center justify-space-around">
        <v-avatar size="80">
          <img
            :src="util.getAssetsFile('Avatar/Avatar1.jpg')"
          >
        </v-avatar>
      </div>
      <v-card-text>
        <div class="text--primary">
          简介
        </div>
      </v-card-text>
      <v-divider
        :thickness="1"
        class="border-opacity-100"
      >
      </v-divider>
      <v-divider
        :thickness="10"
        class="border-opacity-0"
      >
      </v-divider>
      <div>
        <a href="https://github.com/cYeolde" target="_blank" rel="noopener noreferrer">
          <v-btn
            class="mx-16"
            icon="mdi-github"
            variant="tonal"
          ></v-btn>
        </a>
        <a href="https://github.com/ryan6073" target="_blank" rel="noopener noreferrer">
          <v-btn
            class="mx-12"
            icon="mdi-github"
            variant="tonal"
          ></v-btn>
        </a>
      </div>
      <v-card-actions>
        <v-btn
          variant="text"
          color="error"
          @click="reveal = true"
        >
          For More
        </v-btn>
      </v-card-actions>

      <v-expand-transition>
        <v-card
          v-if="reveal"
          class="v-card--reveal"
          style="height: 100%;"
        >
          <v-card-text class="pb-0">
            <p class="text-h4 text--primary">
              what to show？？
            </p>
            <p>待编辑</p>
          </v-card-text>
          <v-card-actions class="pt-0">
            <v-btn
              variant="text"
              color="teal-accent-4"
              @click="reveal = false"
            >
              Back
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-expand-transition>
    </v-card>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from "vue";
import util from "@/utils/util";
const reveal = ref(false);

const messages = [
  {
    avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460',
    name: "John",
    color: "indigo",
  },
  {
    name: "Peter",
    avatar: false,
    color: "deep-purple",
    icon: "mdi-account",
    new: 0,
    total: 0,
  },
];
</script>

<style scoped>
.v-card--reveal {
  bottom: 0;
  opacity: 1 !important;
  position: absolute;
  width: 100%;
}

</style>
