<template>
  <v-container>
    <v-row justify="space-around">
      <v-hover v-slot="{ isHovering, props }">
        <v-card
          width="1170"
          :elevation="isHovering ? 12 : 2"
          :class="{ 'on-hover': isHovering }"
          v-bind="props"
        >
          <v-card-text>
            <v-timeline align="center">
              <v-timeline-item
                v-for="(year, i) in years"
                :key="i"
                :dot-color="year.color"
                size="small"
              >
                <!--自定义时间轴另一面-->
                <template v-slot:opposite>
                  <div
                    :class="`pt-1 headline font-weight-bold text-${year.color}`"
                    @click="onYearClick(year.year)"
                    style="cursor: pointer;"
                  >
                    {{ year.year }}
                  </div>
                </template>
                <div>
                  <h1 :class="`mt-n1 headline font-weight-light mb-4 text-${year.color}`">
                    Lorem ipsum
                  </h1>
                  <div>
                    Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae.
                  </div>
                </div>
              </v-timeline-item>
            </v-timeline>
          </v-card-text>
        </v-card>
      </v-hover>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">

const years = [
  {
    color: 'cyan',
    year: '2019/12/05',
  },
  {
    color: 'green',
    year: '2019/12/23',
  },
  {
    color: 'pink',
    year: '2020/5/24',
  },
  {
    color: 'amber',
    year: '2021/1/22',
  },
  {
    color: 'orange',
    year: '2023/7/11',
  },
];

const onYearClick = (year:String) => {
  // 在这里处理年份文本的点击事件，根据需要执行操作
  console.log(`Year clicked: ${year}`);
};
</script>

<style scoped>

</style>
