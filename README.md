# ding-api

# 介绍
钉钉服务端Java API封装，简化钉钉服务端开发；项目模块化，api接口实现分离解耦等特点，提供各种自定义扩展接口

- 钉钉文档:https://ding-doc.dingtalk.com/doc#/serverapi2/gh60vz/8bRxA
- 目前只封装了spring-boot支持，spring项目可根据spring-boot-starts添加xml文件bean
- 钉钉SDK下载地址：[dingtalk-sdk-java](https://ding-doc.dingtalk.com/doc#/faquestions/vzbp02/8DMhu)
- 钉钉回调加解密：[lippi-oapi-encrpt](https://ding-doc.dingtalk.com/doc#/faquestions/ltr370/19fdd16a)

# 快速开始

## spring-boot



1. 下载：[dingtalk-sdk-java](https://ding-doc.dingtalk.com/doc#/faquestions/vzbp02/8DMhu)，安装到Maven本地仓库

   ```shell
   mvn install:install-file -Dfile= 文件全路径 -DgroupId=com.taobao -DartifactId=taobao-sdk-java -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar
   ```

   

2. 引入Maven依赖

   ```xml
   <dependency>
     <groupId>com.ssp.ding</groupId>
     <artifactId>ding-contacts-spring-boot-starter</artifactId>
     <version>最新版本</version>
   </dependency>
   <!--刚刚安装的钉钉SDK Maven GAV-->
   <dependency>
     <groupId>com.taobao</groupId>
     <artifactId>taobao-sdk-java</artifactId>
     <version>1.0.0-SNAPSHOT</version>
     <optional>true</optional>
   </dependency>
   ```

3. application.properties 配置，[获取钉钉key](https://ding-doc.dingtalk.com/doc#/serverapi2/eev437)

   ```properties
   ding.app-key=钉钉appkey
   ding.app-secret=钉钉secret
   ```

4. 使用api，获取AccessToken和部门列表（AccessToken默认内存存储）

   ```java
   
   @RestController
   @SpringBootApplication
   @RequiredArgsConstructor
   public class DingApiExamplesApplication {
   
       public static void main(String[] args) {
           SpringApplication.run(DingApiExamplesApplication.class, args);
       }
   
       private final DingService dingService;
     
   	  private final DingDepartmentService departmentService;
   
     	/**获取AccessToken*/
       @GetMapping("/hello")
       public String hello() {
           return dingService.getAccessToken();
       }
       /**获取部门列表*/
       @GetMapping("/depts")
       public List<DingDepartmentResponse> deptList() {
           return departmentService.list(1L, true);
       }
   
   }
   ```

5. redis存储AccessToken

   ```properties
   ding.storage-type=redis
   ```

   

# 支持功能(1.0版本)

后期版本支持更多钉钉接口，下面是1.0版本支持列表

- 身份验证
- 通讯录管理
- 事件回调(通讯录)，其他回调与对应模块一起升级

# 其他说明

- **阅读源码的同学请注意，为了简化代码使用了`lombok`支持，如果不了解`lombok`的话，请先学习下相关知识，比如可以阅读[官方文档](https://projectlombok.org/)**

- 要求最低使用JDK1.8

- 如有新功能需求，发现BUG，或者由于微信官方接口调整导致的代码问题，可以直接在[【Issues】](https://github.com/ssp1523/ding-api/issues)页提出issue，便于讨论追踪问题；

  

# 模块说明

## 项目模板分类

- api接口，模块命名规则`ding-模块名称-api`，开发的同学们使用该模块的接口就可以完成钉钉api的调用，也可以基于这些接口自定义实现，包括两部分内容：
  - api Service接口部分，面向使用者提供的java Service接口
  - 接口入参和出参，基本上都是实体类或直接返回java简单类型(如：String，Long，Integer等等)及其集合
- api接口实现，模块命名规则`ding-模块名称`，api接口的实现，目前使用钉钉提供的[dingtalk-sdk-java](https://ding-doc.dingtalk.com/doc#/faquestions/vzbp02/8DMhu)实现
- spring-boot-starters，spring-boot-starter自动装配，不同模块有不同的starter，命名规则：`ding-模块名称-spring-boot-starter`

## 具体模块

- ding-callback 回调实现
- ding-callback-api 回调接口api
- ding-contacts 通讯录实现
- ding-contacts-api 通讯录接口api
- ding-core 钉钉核心实现
- ding-core-api 钉钉核心接口api
- ding-spring-boot-starters 
  - ding-callback-spring-boot-starter 回调starter
  - ding-contacts-spring-boot-starter 通讯录starter
  - ding-core-spring-boot-starter 核心starter
  - ding-message-spring-boot-starter 钉钉群消息starter
- ding-message 群消息实现
- ding-message-api 群消息接口api

## 代码规约说明

了解规约使用起来更轻松

- 每个API Service接口 都对应一个`Api`枚举类与钉钉接口路径相匹配

  - 如：`DingUserService.Api`，包含了所有与用户相关的接口

- `API Service 接口类`命名尽量接近钉钉接口路径中间的一段名称，规则：`Ding中间路径Service`

  - 如：钉钉通讯录用户创建接口：https://oapi.dingtalk.com/user/create

    接口类名：DingUserService

- `API Service 接口方法命名`尽量接近钉钉接口最后一段路径名称，驼峰命名规则

  - 如：钉钉通讯录用户创建接口：https://oapi.dingtalk.com/user/create

    接口方法名：`create`

- `*Request` 代表请求实体

- `*Response` 代表响应实体

- 使用接口时尽量下载源码，这样在开发过程中直接看源码注释能更快的理解接口的使用方法及实体字段的含义