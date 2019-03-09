### Tomcat安装

1.web服务器：接受浏览器请求，进行结果响应。

2.常见的web服务器：Tomcat（apache）、JBoss、websphere、Resin、jetty

3.Tomcat下载

​	http://tomcat.apache.org/download-80.cgi

4.安装：

​	版本：安装版（需安装 jdk,next,next...)

​		   解压版（绿色版     推荐--配置）

​		       需要配置环境变量：JAVA_HOME，CATALINA_HOME(tomcat目录)

5.启动：执行 tomcat_home\bin\startup.bat

6.验证：在浏览器：http://localhost:8080

​		出现【页面内容】则安装成功

#### 7.常见的错误：

​	1）tcnative-1.dll:Can't load AMD 64-bit.dll on a IA 32-bit platform

​	原因：jdk是32位的。

​	通过 java-version检查jdk的版本：如果在第三行找不到64.说明是32位的。

​	解决方案：安装64位的jdk，并且配置好JAVA_HOME可解决此问题。

​	2）执行starup.bat 一闪而过？

​	原因有很多：

​	检查jdk的版本和tomcat版本是否匹配：

![捕获1](C:\Users\Administrator\Desktop\java资料\笔记typora\安装Tomcat+常见错误解决方案\捕获1.PNG)

​	如果不匹配可能一闪而过。

​	如果一闪而过：那么可以在dos命令行去执行startup.bat命令；会将相关信息显示到dos窗口，进而根据dos窗口的提示解决问题。

​	例：jdk8，tomcat8（版本不匹配） 一闪而过；

​		Dos窗口提示配置环境变量：CATALINA_HOME;

​		配置CATALINA_HOME:tomcat_home(在bin目录的上一级);

​	3)正常启动，但是不能访问？

​		原因：启动后关闭窗口。

​		解决方案：重新打开，别关闭（可以考虑将tomcat加入到服务中）

