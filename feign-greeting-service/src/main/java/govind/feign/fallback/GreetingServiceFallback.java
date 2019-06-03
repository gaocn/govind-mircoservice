package govind.feign.fallback;

import govind.feign.service.GreetingService;
import org.springframework.stereotype.Component;

@Component("fallback")
public class GreetingServiceFallback implements GreetingService {
	@Override
	public String greeting(String name) {
		return "【Fallback】greeting + " + name;
	}
}
