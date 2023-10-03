<template>
<v-container>
  <v-hover v-slot="{ isHovering, props }">
    <v-card
      width="1170"
      :elevation="isHovering ? 12 : 2"
      :class="{ 'on-hover': isHovering }"
      v-bind="props">
      <v-row justify="start">
        <v-col cols="12" sm="10" md="20">
          <v-btn prepend-icon="mdi-label" variant="plain" rounded>
            tag1
          </v-btn>
          <v-btn prepend-icon="mdi-label" variant="plain" rounded>
            tag1
          </v-btn>
          <v-btn prepend-icon="mdi-label" variant="plain" rounded>
            tag1
          </v-btn>
          <v-btn prepend-icon="mdi-label" variant="plain" rounded>
            tag1
          </v-btn>
        </v-col>
      </v-row>
    </v-card>
  </v-hover>
</v-container>
</template>

<script setup lang="ts">
</script>

<style scoped>

</style>
