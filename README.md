# 第二组 在线考试系统

#前端

#### 技术：
使用Vue框架搭建前端项目，通过Axios与后端进行数据交互

#### 模块
+ 学生模块
	+ 考试记录查询
    + 考试列表
+ 教师模块
    + 学生信息管理
    + 试题管理
    + 试卷管理
+ 管理员模块
    * 学生信息管理
    * 教师信息管理
    * 试题管理
    * 试卷管理

#### 拓展功能

+ 学生成绩、学生信息excel下载
+ 试题批量上传

# exam
##后端
+ 使用工具 
   * Intelligent Idea编写代码

   * postman后端测试接口

   ![](.\pictures\postman.png)

   * navicat管理数据库

   ![](.\pictures\数据库.png)

   * 阿里云服务器实现远程测试接口

   * xshell和xftp连接服务器

   ![](.\pictures\xsell xftp.png)

   * nginx服务器实现负载均衡

   ![](.\pictures\服务器截图.png)

+ 框架使用
   * 使用了springboot框架

   * 使用springMVC设计框架

    ![](.\pictures\项目结构.png)

   * 使用maven管理jar包

   ![](.\pictures\maven.png)

   * 使用了ssm框架

   ![](.\pictures\mybatis.png)

+ 拓展技术
   
   * 使用了log4j日志框架 实现debug级别以上的日志信息输出到对应文件以及输出sql语句到日志
     
     ![](.\pictures\测试记录.png)
     
   * 利用mybatis整合redis实现了本地二级缓存
     
     ![](.\pictures\redis.png)



+ 实现了批量导入试题以及导出学生信息到excel文件浏览器弹出下载，读取excel文件的功能

