package service.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DatasourceConfiguration {

    private final PostgresProperties properties;

    @Bean
    @LiquibaseDataSource
    public DataSource liquibaseDataSource() {
        final HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName(properties.driverClassName);
        hikariConfig.setJdbcUrl(properties.url);
        hikariConfig.setUsername(properties.username);
        hikariConfig.setPassword(properties.password);
        hikariConfig.setMaximumPoolSize(2);
        hikariConfig.setPoolName("ContactsLiquibasePool");
        return new HikariDataSource(hikariConfig);
    }

}
