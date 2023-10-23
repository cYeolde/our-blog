import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { loadFonts } from './plugins/webfontloader'
import vuetify from './plugins/vuetify'
import './assets/css/waterfall.css'
// @ts-ignore
// import service from './utils/request'
// 预览组件以及样式
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import VueMarkdownEditor from '@kangc/v-md-editor';

//VuePress主题以及样式
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';

//代码高亮
import Prism from 'prismjs';

//代码行数
import createLineNumbertPlugin from '@kangc/v-md-editor/lib/plugins/line-number/index';

//快速复制代码
import createCopyCodePlugin from '@kangc/v-md-editor/lib/plugins/copy-code/index';
import '@kangc/v-md-editor/lib/plugins/copy-code/copy-code.css';



loadFonts();

const app = createApp(App)

app.use(router)
app.use(store)
app.use(vuetify)
VMdPreview.use(vuepressTheme, {Prism});
VMdPreview.use(createLineNumbertPlugin());
VMdPreview.use(createCopyCodePlugin());
app.use(VMdPreview)
// app.config.globalProperties.$service = service
// app.use(service)
app.mount('#app')
