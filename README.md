#### 项目说明
该项目是一个典型的由SpringCloud管理的微服务项目，主要包括如下模块

|服务名 | 父级依赖 | 模块说明|
|----|----|----        |
|SpringCloud|无|为微服务提供统一的pom管理，以及通用组件|  
|EurekaServer|SpringCloud|服务注册中心|  
|EurekaClientFirst|SpringCloud|服务提供者|  
|RestRibbon|SpringCloud|ribbon+restTemplate服务消费者| 
|Feign|SpringCloud|伪Http客户端feign服务消费者| 
|Hystrix|SpringCloud|断路器| 
|Zuul|SpringCloud|路由网关| 
|Config|SpringCloud|分布式服务配置中心| 

---

> 如果大家想了解关于 Spring Cloud 的其它方面应用，也可以以[issues](https://github.com/humingfeng/SpringCloud/issues)的形式反馈给我，我后续来完善。

关注博客：[御前提笔小书童](https://blog.csdn.net/qq_22260641)

关注公众号：开发者的花花世界

![](https://img-blog.csdnimg.cn/20190106225239166.jpg)

---