#### datetime类型数据合理设置（后端存储到数据库）

- 首先设置在插入新记录(default)或更新现有记录时，`upload_time`都会被设置为当前时间。

![image-20231026114643136](..\post_pic\image-20231026114643136.png)

- 然后要实现前端返回的数据被合理解释为datetime格式(进行json数据类型转换，从string到timestamp)：

```java
package com.example.server.form;

import com.example.server.pojo.Pic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
@Data
public class PoiForm {
    private Integer id;
    private String title;
    private String description;
    private String coverUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp uploadTime;

    private List<Pic> picList;

}
```

但是此时后端返回给前端的数据仍然不够令人满意：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "title": "new testtime2",
        "description": "test uploadtime",
        "id": 75489279,
        "uploadTime": "2023-10-12T03:18:26.000+00:00",
        "picList": []
    }
}
```

所以接下来要实现后端的格式数据转回前端能用户友好。

- 同样的，对于后端返回给前端的数据，做一次格式解析：

```java
package com.example.server.vo;

import com.example.server.pojo.Pic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class PoiVo {
    private String title;
    private String description;
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp uploadTime;
    private List<Pic> picList;

}
```

结果良好:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "title": "new testtime3",
        "description": "test uploadtime",
        "id": 402739202,
        "uploadTime": "2023-10-12 11:18:26",
        "picList": []
    }
}
```

