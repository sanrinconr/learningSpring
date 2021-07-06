package com.mercadolibre.romanos_bootcamp;

import com.mercadolibre.romanos_bootcamp.config.SpringConfig;
import com.mercadolibre.romanos_bootcamp.util.ScopeUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ScopeUtils.calculateScopeSuffix();
		new SpringApplicationBuilder(SpringConfig.class).registerShutdownHook(true)
				.run(args);
	}
}
