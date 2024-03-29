package ProjectStudentCard.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class JpaConfiguration {

    @Value("${studentCard.db.host}")
    private String host;
    @Value("${studentCard.db.name}")
    private String dbName;
    @Value("${studentCard.db.port}")
    private String port;
    @Value("${studentCard.db.username}")
    private String username;
    @Value("${studentCard.db.password}")
    private String password;
    @Value("${studentCard.db.version}")
    private String version;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(String.format("jdbc:postgresql://%s:%s/%s", host, port, dbName));
        return dataSource;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setTarget(MigrationVersion.fromVersion(version));
        return flyway;
    }

}

