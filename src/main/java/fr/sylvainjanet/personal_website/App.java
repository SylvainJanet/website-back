package fr.sylvainjanet.personal_website;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		// remove any environment variable values
		// (for now environment variables are used for jobs.dawan.fr developpment)
		SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(App.class)
				.environment(new StandardEnvironment() {
					@Override
					public Map<String, Object> getSystemEnvironment() {
						return new HashMap<>();
					}

					@Override
					public Map<String, Object> getSystemProperties() {
						return new HashMap<>();
					}
				});
		applicationBuilder.run(args);

	}

}
