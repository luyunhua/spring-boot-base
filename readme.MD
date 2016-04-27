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
           