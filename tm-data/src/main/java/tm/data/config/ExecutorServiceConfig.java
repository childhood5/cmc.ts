package tm.data.config;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorServiceConfig {
	
	private Callable<?> executorService;
	
	@Autowired
	public ExecutorServiceConfig(Callable<?> executorService) {
		this.executorService = executorService;
	}
	
	@Bean
	public void executorService() {
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(executorService);
	}
}
