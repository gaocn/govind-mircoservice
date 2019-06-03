1、公开的git仓库
spring cloud config，配置文件，用的是properties的格式，基于git去做
账号：roncoo-eshop
密码：roncoo123456
仓库地址：https://github.com/roncoo-eshop/roncoo-eshop-config
2、application.properties
spring.application.name=config-server
server.port=8767
spring.cloud.config.server.git.uri=https://github.com/roncoo-eshop/roncoo-eshop-config
spring.cloud.config.server.git.searchPaths=config-file
spring.cloud.config.label=master
spring.cloud.config.server.git.username=roncoo-eshop
spring.cloud.config.server.git.password=roncoo123456
3、访问http://localhost:8767/name/dev
4、重构greeting-service
配置一个默认的name，如果前端没有传递name参数，直接取用默认的name
（1）pom.xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
</dependency>
（2）application.yml -> bootstrap.properties
spring.application.name=config-client
spring.cloud.config.label=master
spring.cloud.config.profile=dev
spring.cloud.config.uri= http://localhost:8767/
server.port=8764
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
feign.hystrix.enabled=true
（3）controller
@Value("${defaultName}")
private String defaultName;
没有传递name的时候，默认用spring cloud config中配置的name
