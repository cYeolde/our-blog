<template>
  <v-container>
    <v-banner
      class="font-weight-bold text-medium-emphasis text-h5"
      stacked
    >
      <v-icon start icon="mdi-camera-outline"></v-icon>
      Photos
      <v-banner-text class="text-overline text-disabled">
        Waterfall</v-banner-text>
    </v-banner>
  </v-container>
  <div class="text-center mb-10">
    Columns
    <input
      v-model.number="column"
      :min="1"
      :max="8"
      type="number"
      class="w-[150px] outline-none border border-zinc-800 rounded px-2 py-0.5"
    />
  </div>
  <div
    ref="containerRef"
    class="px-10 md:px-20 lg:px-40 xl:px-60 relative"
    :style="{ height: containerHeight + 'px' }"
  >
    <div
      v-for="(item,i) in waterfallData"
      :key="i"
      class="item absolute duration-300"
      :style="{ width: columnWidth + 'px' }"
    >
      <img
        :src="item.src"
        alt=""
        :style="{ height: (columnWidth / item.width) * item.height + 'px' }"
        class="rounded"
      />
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, nextTick, watch } from 'vue'
import waterfallData from '@/utils/waterfallData'

const column = ref(2)
const rowSpacing = ref(20)
const columnSpacing = ref(20)

const containerRef = ref<HTMLElement | null>(null)
// 容器总宽度
const containerWidth = ref(0)
// 容器总高度
const containerHeight = ref(0)
// 列宽 = (容器宽度 - 列间距 * (列数 - 1)) / 列数
const columnWidth = ref(0)
const containerLeft = ref(0)
// 计算容器宽度
const useContainerWidth = () => {
  const { paddingLeft, paddingRight } = window.getComputedStyle(containerRef.value!)
  containerLeft.value = parseFloat(paddingLeft)
  containerWidth.value =
    containerRef.value!.clientWidth - parseFloat(paddingLeft) - parseFloat(paddingRight)
}
// 计算列宽
const useColumnWidth = () => {
  columnWidth.value =
    (containerWidth.value - columnSpacing.value * (column.value - 1)) / column.value
}
// 获取最小高度
const getMinHeight = (arr: number[]) => {
  return Math.min(...arr)
}
// 获取最小高度的索引
const getMinHeightIndex = (arr: number[]) => {
  return arr.indexOf(getMinHeight(arr))
}

// 获取所有图片的高度
const itemHeights = ref<number[]>([])
const useItemHeight = () => {
  const allItems = document.querySelectorAll<HTMLElement>('.item')
  itemHeights.value = Array.from(allItems).map((item) => item.clientHeight)
}

const columnHeights = ref(Array(column.value).fill(0))

const getItemLeft = () => {
  const column = getMinHeightIndex(columnHeights.value)
  return (columnWidth.value + columnSpacing.value) * column + containerLeft.value
}

const getItemTop = () => {
  return getMinHeight(columnHeights.value)
}

const increaseColumnHeight = (index: number) => {
  const minHeightColumnIndex = getMinHeightIndex(columnHeights.value)
  columnHeights.value[minHeightColumnIndex] += itemHeights.value[index] + rowSpacing.value
}
// 计算每个 item 的位置
const useItemPosition = () => {
  const allItems = document.querySelectorAll<HTMLElement>('.item')
  allItems.forEach((item, index) => {
    item.style.left = getItemLeft() + 'px'
    item.style.top = getItemTop() + 'px'
    increaseColumnHeight(index)
  })
  containerHeight.value = Math.max(...columnHeights.value)
}

onMounted(() => {
  useContainerWidth()
  useColumnWidth()

  nextTick(() => {
    useItemHeight()
    useItemPosition()
  })
})

watch(column, (value) => {
  columnHeights.value = Array(value).fill(0)
  useColumnWidth()
  nextTick(() => {
    useItemHeight()
    useItemPosition()
  })
})
</script>


