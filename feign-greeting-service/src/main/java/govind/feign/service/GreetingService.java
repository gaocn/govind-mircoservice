package govind.feign.service;


import govind.feign.fallback.GreetingServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-service", fallback = GreetingServiceFallback.class)
public interface GreetingService {
	@GetMapping("/hello")
	String greeting(@RequestParam(value = "name") String name);
}
