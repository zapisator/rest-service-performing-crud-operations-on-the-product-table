package service.repository;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "spring.postgres")
@Data
public class PostgresProperties {
    String host;
    String port;
    String database;
    String username;
    String password;
    String driverClassName;
    String url;
}
