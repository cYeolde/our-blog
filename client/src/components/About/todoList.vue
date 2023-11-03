<template>
  <div>
      <v-card
        class="mx-auto"
        max-width="600"
        elevation="5"
        >
<!--        outlined-->
<!--        :style="{  border: '5px solid grey' }"-->

        <v-card-title class="font-italic text-center">To-Do List</v-card-title>

        <v-text-field
          label="New task!(Title/Subtitle)"
          style="width:100%;"
          v-model="taskText"
          @input="searchTask"
          @keyup.enter="handleEnterKey"
        >
          <template v-slot:append>
            <v-btn
              icon="mdi-plus"
              variant="text"
              @click="addTask"
            ></v-btn>
          </template>
        </v-text-field>

        <v-tabs
          v-model="tab"
          bg-color="transparent"
          color="basil"
          align-tabs="center"
        >
          <v-tab
            class="tab"
            :class="active === 0 ? 'tab-primary' : 'tab-secondary'"
            @click="changeActive(0)"
          >
            All({{todoList.length}})
          </v-tab>
          <v-tab
            class="tab"
            :class="active === 1 ? 'tab-primary' : 'tab-secondary'"
            @click="changeActive(1)"
          >
            Finished({{todoList.filter(item=>item.isCompleted).length}})
          </v-tab>
          <v-tab
            class="tab"
            :class="active === 2 ? 'tab-primary' : 'tab-secondary'"
            @click="changeActive(2)"
          >
            Unfinished({{todoList.filter(item=>!item.isCompleted).length}})
          </v-tab>
        </v-tabs>

        <v-list lines="three" select-strategy="classic">
          <v-list-item
            v-for="item in filteredTodoList" :key="item.id"
          >
            <template v-slot:prepend="{ isActive }">
              <!--头部：复选框-->
              <v-list-item-action start>
                <v-checkbox-btn :model-value="isActive"
                                v-model="item.isCompleted"
                ></v-checkbox-btn>
              </v-list-item-action>
            </template>
            <v-list-item-title :style="{ 'text-decoration': item.isCompleted ? 'line-through' : 'none' }">{{ item.task }}</v-list-item-title>
            <v-list-item-subtitle>{{item.description}}</v-list-item-subtitle>
            <!--尾部：标签-->
            <template v-slot:append>
              <v-list-item-action end>
                <!--根据isCompleted的值来判断显示哪个标签-->
                <v-chip :color="item.isCompleted?'green':'pink'" label>
                  {{item.isCompleted?'finished':'unfinished'}}
                </v-chip>
                <!--删除按钮-->
                <v-btn
                  icon="mdi-delete-outline"
                  variant="plain"
                  @click="deleteTask(item.id)">
                </v-btn>
              </v-list-item-action>
            </template>
          </v-list-item>

          <v-list-item
            v-if="filteredTodoList.length===0"
            class="text-center"
          >
            <v-list-item-title>
              {{active===0?'No task':'No '+ (active===1?'finished':'unfinished')+' task'}}
            </v-list-item-title>
          </v-list-item>
        </v-list>

        <!--一键清除已完成任务-->
        <div class="text-center" style="display: flex; justify-content: center; margin-top: 10px;">
          <v-btn
            variant="plain"
            @click="deleteAllFinishedTask"
          >
            Empty finished task
          </v-btn>
        </div>
      </v-card>
  </div>


</template>

<script setup lang="ts">
import {ref, computed,defineEmits} from "vue";
const todoList=ref([
  {id:1,task:'睡觉',description:'起床了',isCompleted:true},
  {id:2,task:'吃饭',description:'吃吃吃',isCompleted:false},
  {id:3,task:'打豆豆',description:'为啥我给睡觉打勾，是打豆豆已完成...',isCompleted:false},
]);

const tab = ref(0);
const active = ref(0);
const emits = defineEmits(["changeActive"]);
const changeActive = (index: number) => {
  active.value = index;
  emits("changeActive", index);
};

const taskText = ref("");
//搜索任务
const filteredTodoList = computed(() => {
  const searchLowercase= taskText.value.toLowerCase();
  if (active.value === 0) {
    return todoList.value.filter((item) =>
      item.task.toLowerCase().includes(searchLowercase)
    );
  }
  else if (active.value === 1) {
    return todoList.value.filter((item) =>
      item.isCompleted &&
      item.task.toLowerCase().includes(searchLowercase)
    );
  } else {
    return todoList.value.filter((item) =>
      !item.isCompleted &&
      item.task.toLowerCase().includes(searchLowercase)
    );
  }
});

const addTask=()=>{
  const taskInputText = taskText.value.trim();
  if (taskInputText) {
    // 检查是否已经存在相同的任务
    const existTask = todoList.value.find(
      (item) => item.task.toLowerCase() === taskInputText.toLowerCase()
    );
    if (existTask) {
      if (!existTask.isCompleted) {
        // 设置警告消息
        alert('任务已存在');
        return;
      }
    }
    // 将输入文本以分隔符分开为标题和副标题
    const [taskTitle, taskSubtitle] = taskInputText.split('/');
    todoList.value.push({
      id: todoList.value.length + 1,
      task: taskTitle,
      description: taskSubtitle || 'this is a new task.', // 如果副标题为空，则使用默认副标题
      isCompleted: false
    });
    taskText.value='';//清空输入框
  }
};
const searchTask=()=>{
  if(taskText.value.trim()===''){
    tab.value=0;
  }
};
const handleEnterKey=()=>{//回车键添加任务
  addTask();
};

const deleteTask=(id:number)=>{
  const index=todoList.value.findIndex(item=>item.id===id);
  todoList.value.splice(index,1);
};

const deleteAllFinishedTask=()=>{
  todoList.value=todoList.value.filter(item=>!item.isCompleted);
};

</script>

<style scoped>

</style>
