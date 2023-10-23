import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { loadFonts } from './plugins/webfontloader'
import vuetify from './plugins/vuetify'
import './assets/css/waterfall.css'

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


VMdPreview.use(vuepressTheme, {
  Prism,
});
VMdPreview.use(createLineNumbertPlugin());
VMdPreview.use(createCopyCodePlugin());

loadFonts();


createApp(App)
  .use(router)
  .use(store)
  .use(vuetify)
  .use(VMdPreview)
  .mount('#app')
