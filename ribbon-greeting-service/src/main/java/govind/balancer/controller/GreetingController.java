package govind.balancer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import govind.balancer.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	@Autowired
	private GreetingService greetingService;

	@GetMapping("/greeting")
	@HystrixCommand(fallbackMethod = "greetingFallback")
	public String greeting(@RequestParam String name) {
		return greetingService.greeting(name);
	}

	public String greetingFallback(String name) {
		return "【Fallback】error, " + name;
	}
}
