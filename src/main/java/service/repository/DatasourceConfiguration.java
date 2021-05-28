package service.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DatasourceConfiguration {

    @Bean
    public DataSource liquibaseDataSource() {
        final HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName(org.postgresql.Driver.class.getName());
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgresql");
        hikariConfig.setUsername("sa");
        hikariConfig.setPassword("password");

        hikariConfig.setMaximumPoolSize(2);
        hikariConfig.setPoolName("ContactsLiquibasePool");

        return new HikariDataSource(hikariConfig);
//    public DataSource datasource() {
//        return DataSourceBuilder.create()
//                .driverClassName(org.postgresql.Driver.class.getName())
//                .url("jdbc:postgresql://localhost:5432/postgresql")
//                .username("sa")
//                .password("password")
//                .build();
    }

}
