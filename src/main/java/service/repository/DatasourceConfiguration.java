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

        System.out.printf(
                "host: %s\nport: %s\ndatabase: %s\nusername: %s\npassword: %s\n",
                properties.host, properties.port, properties.database, properties.username, properties.password
        );
        final HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName(org.postgresql.Driver.class.getName());
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgresql");
        hikariConfig.setUsername("diasoft");
        hikariConfig.setPassword("diasoft");

        hikariConfig.setMaximumPoolSize(2);
        hikariConfig.setPoolName("ContactsLiquibasePool");

        return new HikariDataSource(hikariConfig);
    }

}
