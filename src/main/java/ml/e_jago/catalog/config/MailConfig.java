package ml.e_jago.catalog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Component
@ConfigurationProperties(prefix = "jago.mail.server")
@Getter
@Setter
public class MailConfig {

    private String host;
    private int port;
    private String username;
    private String instance;
}
