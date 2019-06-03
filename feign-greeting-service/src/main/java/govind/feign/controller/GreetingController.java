package govind.feign.controller;

import com.netflix.discovery.converters.Auto;
import govind.feign.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;

@RestController
public class GreetingController {
	private final GreetingService greetingService;

	@Value("${server.port}")
	private String port;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam String name) {
		return "[" + port + "]" + greetingService.greeting(name);
	}

}
