#Maven 搭建spring boot多模块项目

***
**备注:所有项目都在idea中创建**
###1.idea创建maven项目
   - 1-1:  删除`src`,`target`目录，只保留`pom.xml`
   - 1-2:  根目录`pom.xml`可被子模块继承,因此项目只是demo,未考虑太多性能问题,所以将诸多依赖
           都写在根级`pom.xml`，子模块只需继承就可以使用。
   - 1-3:  根级`pom.xml`文件在附录1
   - 1-4:  依赖模块 mybatis spring-boot相关模块
   
###2.创建子模块(module)

   - 2-1: `file > new > module` 输入 `model`
   - 2-2: `file > new > module` 输入 `dao`
   - 2-3: `file > new > module` 输入 `service`
   - 2-4: `file > new > module` 输入 `webapi`
   
###3.修改子模块pom.xml配置
```   
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>parent</artifactId>
        <groupId>com.luyh.projectv1</groupId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>projectv1-model</artifactId>
</project>
```
注意:<font color="red">`<relativePath>../pom.xml</relativePath>`</font>此段必须加上,用来继承父模块


****
**至此,项目的基础结构搭建完毕了,接下来可以来撸代码了,哦哦稍等,我先介绍下各个子module的工作职责吧**

###4.子模块在项目中担任的'工作职责'

  - `model`   此模块存放着所有的实体类
  - `dao`     此模块存放着数据交互的具体实现,供service调用
  - `service` 此模块存放业务代码实现,供API层调用
  - `webapi`  此模块也可以不出现在项目中,为了写demo故将webapi层放进来
    
           