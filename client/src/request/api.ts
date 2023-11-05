// @ts-ignore
import instance from "./request";

//一般情况下，接口类型会放到一个文件
// 下面两个TS接口，表示要传的参数
interface ReqLogin {
  name: string
  paw: string
}
interface ReqStatus {
  id: string
  navStatus: string
}

// Res是返回的参数，T是泛型，需要自己定义，返回对数统一管理***
type Res<T> = Promise<ItypeAPI<T>>;
// 一般情况下响应数据返回的这三个参数，
// 但不排除后端返回其它的可能性，
interface ItypeAPI<T> {
  data: T,//请求的数据，用泛型
  msg: string | null // 返回状态码的信息，如请求成功等
  code: number //返回后端自定义的200，404，500这种状态码
}

// 文章分页列表
export const getArticleListApi = (pageNum:number, pageSize:number) => {
  return instance.get("/poi/list", {
    params: { pageNum, pageSize }
  });
}

// 文章详情
export const getArticleDetailApi = (id:number) => {
  return instance.get(`/poi/detail/${id}`);
}

//文章分类
export const getListByClassifyApi = (classifyName:string,pageNum:number) => {
  return instance.get("/poi/classify", {
    params: { classifyName, pageNum }
  });
}

//文章标签
export const getTagApi= () => {
  return instance.get("/getTag");
}
export const getListByTagApi = (tagName:string,pageNum:number) => {
  return instance.get("/poi/listByTag", {
    params: { tagName, pageNum }
  });
}

//文章归档
export const getArchiveApi = () => {
  return instance.get("/poi/listAll");
}
