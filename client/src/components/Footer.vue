<template>
  <div class="footer-wrapper">
    <v-layout>
      <v-container>
        <v-footer border
                  class="text-center d-flex flex-column"
                  color="rgba(0, 0, 0, 0)"
        >
          <div>
            <a href="https://github.com/cYeolde" target="_blank" rel="noopener noreferrer">
              <v-btn
                class="mx-4"
                icon="mdi-github"
                variant="text"
              ></v-btn>
            </a>

            <a href="https://github.com/cYeolde" target="_blank" rel="noopener noreferrer">
              <v-btn
                class="mx-4"
                icon="mdi-google"
                variant="text"
              ></v-btn>
            </a>

            <a href="https://github.com/cYeolde" target="_blank" rel="noopener noreferrer">
              <v-btn
                class="mx-4"
                icon="mdi-instagram"
                variant="text"
              ></v-btn>
            </a>
          </div>

          <div class="pt-0">
            cccccssssss
          </div>

          <v-divider></v-divider>

          <div>
            {{ new Date().getFullYear() }} — <strong>Bloggggg</strong>
          </div>
        </v-footer>
      </v-container>
    </v-layout>
  </div>
</template>

<script setup lang="ts">

</script>

<style scoped>

</style>
