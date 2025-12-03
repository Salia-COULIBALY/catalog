package ml.e_jago.catalog;

import ml.e_jago.catalog.config.MailConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MailConfig.class)
public class CatalogApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}

}
