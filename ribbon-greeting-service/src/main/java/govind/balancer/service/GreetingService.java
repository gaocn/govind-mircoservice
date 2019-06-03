package govind.balancer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {

	private final RestTemplate restTemplate;

	public GreetingService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String greeting(String name) {
		return restTemplate.getForObject("http://hello-service/hello?name=" + name, String.class);
	}
}
