package govind.balancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//向eureka注册自己作为一个服务的调用，而EnableEurekaClient代表的是向eureka注册自己将自己作为一个服务
@EnableDiscoveryClient
public class RibbonBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonBalancerApplication.class, args);
	}

	/**
	 * 在spring容器中注入一个bean：RestTemplate，作为rest服务接口调用的
	 * 客户端。
	 * LoadBalanced标注，代表对服务多个实例调用时开启负载均衡
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
