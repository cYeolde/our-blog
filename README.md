# 个人博客系统

## 1、介绍

### 1.1、项目简介

Vue3+Spring Boot 前后端分离博客系统，采用响应式布局兼容PC端和移动端。

### 1.2、主要功能

- 首页：文章分页展示、标签云、个人简介
- 博文页：文章详情展示
- 图片页：瀑布流布局，支持自定义列数改变布局
- 分类页：单个分类下文章分页展示
- 标签页：单个标签下文章分页展示
- 归档页：以时间轴展示文章列表
- 任务清单

## 2、软件架构

### 2.1、后端技术

| 技术            | 说明                        | 官方网址                                                     |
| --------------- | --------------------------- | ------------------------------------------------------------ |
| Spring Boot     | MVC框架和容器               | [ https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot) |
| MyBatis-Plus    | 持久层框架                  | [MyBatis-Plus (baomidou.com)](https://baomidou.com/)         |
| Spring Web      | Spring Framework的Web模块   | https://spring.io/                                           |
| Lombok          | 简化对象封装工具            | [https://github.com/rzwitserloot/lombok](https://github.com/rzwitserloot/lombok) |
| MySQL Connector | 与MySQL数据库进行连接和交互 | [MySQL :: MySQL Connectors](https://www.mysql.com/products/connector/) |

### 2.2、前端技术

| **技术**        | **说明**                | **官方网址**                                                 |
| --------------- | ----------------------- | ------------------------------------------------------------ |
| Vue.js          | 前端JavaScript框架      | [ https://vuejs.org/](https://vuejs.org/)                    |
| Vite            | 前端构建工具            | [https://vitejs.dev/](https://vitejs.dev/)                   |
| Vutify          | 基于Vue3的UI组件库      | https://vuetifyjs.com/                                       |
| Vue-Router      | Vue.js的官方路由管理器  | [https://router.vuejs.org/zh/](https://router.vuejs.org/zh/) |
| Axios           | 基于promise的网络请求库 | [https://axios-http.com/](https://axios-http.com/)           |
| Vue-CLI         | Vue.js 开发的标准工具   | [https://cli.vuejs.org/zh/](https://cli.vuejs.org/zh/)       |
| Vuex            | Vue.js的官方状态管理库  | [https://vuex.vuejs.org/](https://vuex.vuejs.org/)           |
| v-md-editor     | Markdown编辑器          | http://ckang1229.gitee.io/vue-markdown-editor/zh/            |
| Gitalk          | GitHub评论插件          | [https://github.com/gitalk/gitalk](https://github.com/gitalk/gitalk) |
| Echarts         | 数据可视化库            | [https://echarts.apache.org/](https://echarts.apache.org/)   |
| Material Design | 图标字体库              | [https://m3.material.io/](https://m3.material.io/)           |

### **2.3、开发工具**

| **工具名**            | **说明**           | **官方网址**                                                 |
| --------------------- | ------------------ | ------------------------------------------------------------ |
| WebStorm 2023.1.4     | 前端主要开发工具   | [https://www.jetbrains.com/webstorm/](https://www.jetbrains.com/webstorm/) |
| IntelliJ IDEA 2021.03 | 后端主要开发工具   | [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download) |
| Navicat               | 数据库连接管理工具 | [http://www.formysql.com/xiazai.html](http://www.formysql.com/xiazai.html) |
| Postman               | API接口调试工具    | [ https://www.postman.com/](https://www.postman.com/)        |
| Typora                | Markdown编辑器     | [https://typora.io/](https://typora.io/)                     |

### **2.4、开发环境**

| **工具名** | **说明/版本号**        | **官方网址**                                                 |
| ---------- | ---------------------- | ------------------------------------------------------------ |
| JDK        | 软件开发工具包/1.8     | [https://www.oracle.com/java/technologies/downloads/#java8-windows](https://www.oracle.com/java/technologies/downloads/#java8-windows) |
| Mysql      | 数据库管理系统/8.1     | [https://www.mysql.com/downloads/](https://www.mysql.com/downloads/) |
| Redis      | 非关系型数据库/3.2.100 | [https://redis.io/download](https://redis.io/download)       |

## **3、使用说明**

### **3.1、数据库配置**

**当你拿到项目后，创建完数据库后，要去项目的`application.yml`中去配置你的数据库配置。**

```yml
  datasource:
    url: jdbc:mysql://# 你本地的IP地址:3306/blog?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8
    username: #数据库用户名
    password: #数据库连接密码
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### **3.2、地址配置**

```yml
upload:
  local:
    path: /blog/uploadFile/
    url: # 你本地的访问地址， 例如：http://localhost:8080/blog

```

## **4、项目展示**

#### 4.1、首页

PC端:

![Home1](.\img\Home1)

移动端:

1.<img src=".\img\Home2" alt="Home2" style="zoom: 25%;" />     2.<img src=".\img\Home3" alt="Home3" style="zoom: 25%;" />    3.<img src=".\img\Home4" alt="Home4" style="zoom: 25%;" />

#### 4.2、博文详情页

PC端：

![Article1](.\img\Article1)

移动端：

<img src=".\img\Article2" alt="Article2" style="zoom: 25%;" />

#### 4.3、图片页

PC端：

![Photo1](.\img\Photo1)

移动端：

<img src=".\img\Photo2" alt="Photo2" style="zoom: 25%;" />

#### 4.4、分类页

PC端：

![Classify](.\img\Classify1)

移动端：

<img src=".\img\Classify2" alt="Classify2" style="zoom: 25%;" />

#### 4.5、标签页

PC端：

![Tag1](.\img\Tag1)

![Tag2](.\img\Tag2)



移动端：

1.<img src=".\img\Tag3" alt="Tag3" style="zoom: 25%;" />                        2.  <img src=".\img\Tag4" alt="Tag4" style="zoom: 25%;" />



#### 4.6、归档页

PC端：

![Archive1](.\img\Archive1)

移动端：

<img src=".\img\Archive2" alt="Archive2" style="zoom:25%;" />

#### 4.7、任务清单

PC端：

![About1](.\img\About1)

移动端：

<img src=".\img\About2" alt="About2" style="zoom:25%;" />
