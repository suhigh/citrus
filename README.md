
<p align="center">
  <a href="https://github.com/Yiuman/citrus">
   <img alt="citrus-logo" src="./logo.png" />
  </a>
</p>

<h1 align="center">Citrus: 低代码开发脚手架</h1>

<p  align="center">
 <a href="https://github.com/Yiuman/citrus/blob/master/LICENSE">
    <img alt="code style" src="https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg">
  </a>
  <a href="http://spring.io/projects/spring-boot">
    <img alt="springboot-2.5.2" src="https://img.shields.io/badge/spring--boot-2.5.2-release.svg">
  </a>
  <a href="http://mp.baomidou.com">
    <img alt="mybatis-plus-3.4.3" src="https://img.shields.io/badge/mybatis--plus-3.4.3-blue.svg">
  </a>
   <a href="https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.yiuman%22%20AND%20a%3A%22citrus%22">
    <img alt="maven" src="https://img.shields.io/maven-central/v/com.github.yiuman/citrus?style=flat">
</p>


### 项目简介

:rainbow:  低代码快速开发脚手架

前后端分离架构，基于SpringBoot2.x + SpringSecurity + JWT + Mybatis-plus + Activiti7 

灵活、高效，降低开发成本



**前端仓库地址**：https://github.com/Yiuman/citrus-vuetify

:smile:  [我是一个活生生的例子](http://42.192.95.146/#/login)

欢迎issues、PR~~  如果此项目对你有所帮助，麻烦动动小手给个小星星:star:



### 项目特性

1. 开箱即用，引入starter依赖后即可启动
2. 高效开发，只需要定义实体与库表，入口继承基类的Controller，即可完成基础的增删改查操作
3. 常用数据结构的封装与基础的CRUD实现（左右值预遍历树、普通树等）
4. 统一的认证入口，方便的安全认证扩展，可实现多种方式的认证，且支持表单与接口
5. 灵活的权限钩子，既可全局进行权限验证、亦可定义于类与方法，验证方式易与扩展
6. 细粒度的RBAC权限控制，可自定义验证方式，支持数据范围注入
7. 动态数据源+多数据源事务管理
8. 封装activiti7工作流，多实例加签，任务跳转



### 项目结构/模块设计及使用指南

- `citrus-boot-starter` 项目自动配置相关
- `citrus-main` 项目的运行入口（体验开箱即用的快感）
- `citrus-security` 项目安全相关的代码，统一认证、验证码类型、鉴权、jwt等  [安全模块传送门](https://github.com/Yiuman/citrus/tree/master/doc/安全模块设计.md)
- `citrus-support` 项目通用支持相关的代码，通用Service层、Controller层，工具类、缓存、异常、注入、数据结构、动态数据源及相关扩展 [通用CRUD指南](https://github.com/Yiuman/citrus/tree/master/doc/通用CRUD指南.md) 、[多数据源及事务](https://github.com/Yiuman/citrus/tree/master/doc/多数据源及事务.md)
- `citrus-system` 项目系统设计的主要实现  包含用户、角色、权限、资源、菜单、数据范围等模块的实现与处理，数据范围注入也在这里 [权限数据范围设计](https://github.com/Yiuman/citrus/tree/master/doc/权限设计.md)
- `citrus-workflow` 整合activiti7的工作流模块，实现多维度人员解析、加签、跳转功能  [acitivi模型设计器](http://42.192.95.146:18080/)
- `citrus-workflow-impl` 系统模块与工作流模块结合的工作流相关实现



### 如何使用

#### 方式一

 1. springboot项目中引入最新的依赖 见readme顶部微章

    ```xml
    <dependency>
      <groupId>com.github.yiuman</groupId>
      <artifactId>citrus-boot-starter</artifactId>
      <version>${latest}</version>
    </dependency>
    ```

2. 下载 https://github.com/Yiuman/citrus/tree/master/sql  中的sql文件，创建你的数据并执行（多数据源请见多数据源及事务使用指南）

3. 在`application.yml`中配置数据库及应用信息

    ```yml
    spring:
      datasource:
        driver-class-name: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/citrus?zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8
        username: root
        password: yiuman
    server:
      port: 8082
    ```
    
4. 启动项目

#### 方式二

1. 克隆项目 `git clone https://github.com/Yiuman/citrus.git`
   
2. 自行修改项目配置与代码

3. 启动项目













