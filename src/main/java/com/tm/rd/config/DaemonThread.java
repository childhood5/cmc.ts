package com.tm.rd.config;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DaemonThread {
	
	private Callable<?> callable;
	
	@Autowired
	public DaemonThread(Callable<?> callable) {
		this.callable = callable;
	}
	
	@Bean
	public void executorService() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
	    executor.submit(callable);
	}
}
