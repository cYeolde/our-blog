<template>
  <v-container>
    <v-card
      class="mx-auto"
      max-width="344"
    >
      <v-card-title class="text-h5 font-italic text-brown-darken-1">
        <v-icon color="brown-darken-4">mdi-tag-outline</v-icon>
        标签云
      </v-card-title>
      <div id="wordCloud" style="width: 344px; height: 344px;"></div>
    </v-card>
  </v-container>
</template>

<script setup lang="ts">
import * as echarts from 'echarts';
import 'echarts-wordcloud';
import { ref,onMounted } from 'vue';
import router from "@/router";
import {getTagApi} from "@/request/api";

// const echartsData=ref([]);
//
// const generateRandomValue= () => {
//   return Math.floor(Math.random() * 100);
// };
//
const generateRandomColor = () => {
  return `rgb(${Math.floor(Math.random() * 100) + 155}, ${Math.floor(Math.random() * 100) + 155}, ${Math.floor(Math.random() * 100) + 155})`;
};
//
// const getTag = async () => {
//   let res = await getTagApi();
//   console.log(res.data);
//   echartsData.value=res.data;
//   console.log(echartsData.value);
// };

const echartsData = [
  { value: '30', name: '123' },
  { value: '29', name: '标签2' },
  { value: '28', name: '标签3' },
  { value: '27', name: '标签4' },
  { value: '26', name: '标签5' },
  { value: '25', name: '标签6' },
  { value: '24', name: '标签7' },
  { value: '23', name: '标签8' },
  { value: '22', name: '标签9' },
  { value: '21', name: '标签10' },
  { value: '20', name: '标签11' },
  { value: '16', name: '标签12' },
  { value: '15', name: '标签13' },
  { value: '14', name: '标签14' },
  { value: '13', name: '标签15' },
  { value: '12', name: '标签16' },
  { value: '11', name: '标签17' },
  { value: '10', name: '标签18' },
  { value: '9', name: '标签19' },
];

const initChart = () => {
  const myChart = echarts.init(document.getElementById('wordCloud'));
  const option = {
    title: {
      text: '',
      x: "center"
    },
    series: [
      {
        type: "wordCloud",
        gridSize: 10,
        sizeRange: [14, 40],
        rotationRange: [0, 0],
        textStyle: {
          color: generateRandomColor, // 使用生成的颜色
        },
        left: "center",
        top: "center",
        right: null,
        bottom: null,
        width: "100%",
        height: "100%",
        data: echartsData
      }
    ]
  };
  myChart.setOption(option);

  myChart.on('click', function (params) {
    console.log('myChart----click---:', params, '------', params.name);
    router.push(`/tags/${params.name}`);//跳转到对应标签的文章列表页
  });
};

onMounted(() => {
  initChart();
});


</script>

<style scoped>

</style>
