#### 前端向后端同时传输json和文件，后端解析

![image-20231026162608007](..\post_pic\image-20231026162608007.png)

现在要传输这样的数据，并且要解析json数据获得真正需要的Java对象数据，需要将json格式数据以string类型传入后端再进行解析：

![image-20231026162815809](..\post_pic\image-20231026162815809.png)

通过使用一个JSON解析库（Jackson）而不是直接使用Blob。

```java
import com.fasterxml.jackson.databind.ObjectMapper;

// ...

ObjectMapper mapper = new ObjectMapper();
PoiForm poiForm = mapper.readValue(poiFormStr, PoiForm.class);
```

