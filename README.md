# SpringCloudDemo

### Spring Cloud Eureka构建微服务架构

注册中心：eureka-server

服务网关：api-gateway

服务生产者：eureka-producer

服务消费者：eureka-consumer


### 各服务启动后，浏览器访问：

注册中心：http://localhost:7000/

![image](https://user-images.githubusercontent.com/15326847/144178586-91733711-99ee-4f89-b245-7d18dd89212e.png)


通过网关调用消费者接口：http://localhost:14000/eureka-consumer/hello/kotlin?token=2233
