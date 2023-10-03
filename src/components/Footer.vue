<template>
 <v-layout>
   <v-container>
     <v-footer border
       class="text-center d-flex flex-column"
       color="rgba(0, 0, 0, 0)"
     >
       <div>
         <v-btn
           v-for="icon in icons"
           :key="icon"
           class="mx-4"
           :icon="icon"
           variant="text"
         ></v-btn>
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
</template>

<script setup lang="ts">
const icons = [
  'mdi-github',
  'mdi-google',
  'mdi-instagram',
]
</script>

<style scoped>

</style>
