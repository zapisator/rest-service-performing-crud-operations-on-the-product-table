package service.repository;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datasource")
@Data
public class H2Properties {

    private String url;
    private String driverClassName;
    private String username;
    private String password;

}
