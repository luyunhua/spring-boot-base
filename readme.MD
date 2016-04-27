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

###5.`model`层实体类编写

  - 建立包名 `com.luyh.projectv1.model`
  - 建实体类 `Member.java` 具体代码请clone我的git,git地址在最下方

###6.`dao`层数据库操作层
  - 建立com.luyh.projectv1.dao.config,该包内只有2个让spring boot自动加载配置的配置java类
  - 建立MemberMapper.java 具体内容看代码
  - 在resources/mybatis 下建立MemberMapper.xml
  - 建立IMember.java
  - 建立Member.java 实现Imember接口
  - 建立resources/application.properties文件用于配置数据库连接

###7. `service` 编写业务逻辑
  - 建立 `com.luyh.projectv1.service` 包
  - 建立IMemberService.java接口
  - 建立MemberService.java实现类
  - MemberService.java 类中自动注入DaoMember 并调用其方法获取数据

###8. `webapi` 编写webapi获取json数据
 - 建立Application.java 启动应用
 - 建立 `com.luyh.projectv1.webapi.controller.MemberController.java` 写个rest风格Controller
 - 启动
 
###9.sql文件  请自行导入mysql数据 sql文件
****

**[这里是项目地址,点击下载](https://github.com/luyunhua/spring-boot-base)**

  
  
  
  
###附录1
```

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.luyh.projectv1</groupId>
    <artifactId>parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.3.RELEASE</version>
    </parent>
    <modules>

        <module>model</module>
        <module>dao</module>
        <module>service</module>
        <module>webapi</module>
    </modules>

    <!--申明依赖关系-->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.2.2</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.2.8</version>
        </dependency>

        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jdbc</artifactId>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    </dependencies>

    <!--设置maven仓库-->

    <repositories>
        <repository>
            <id>spring-releases</id>
            <url>https://repo.spring.io/libs-release</url>
        </repository>
    </repositories>
    <pluginRepositories>
        <pluginRepository>
            <id>spring-releases</id>
            <url>https://repo.spring.io/libs-release</url>
        </pluginRepository>
    </pluginRepositories>


</project>
```
    
           