package govind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 在Hystrix dashboard中添加：
 * 		http://localhost:8085/turbine.stream
 *  就可以监控多个服务的聚合信息
 */
@SpringBootApplication
@EnableTurbine
public class HystrixTurbineServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineServerApplication.class, args);
	}

}
