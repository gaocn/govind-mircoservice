package govind.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * http://localhost:8084/hystrix
 * 输入http://localhost:8084/hystrix.stream和title
 * 访问接口，会在hystrix dashboard看到访问请求
 *
 * 若出现：Unable to connect to Command Metric Stream.
 * 需要添加配置：
 * management.endpoints.web.exposure.include = hystrix.stream
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class FeignGreetingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignGreetingServiceApplication.class, args);
	}
}
