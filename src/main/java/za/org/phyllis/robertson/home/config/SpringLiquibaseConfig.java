package za.org.phyllis.robertson.home.config;

import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.util.StopWatch;
import za.org.phyllis.robertson.home.event.publisher.SqlMigrationEventPublisher;

import javax.sql.DataSource;
import java.util.concurrent.CompletableFuture;

@Log4j2
@Configuration
public class SpringLiquibaseConfig extends SpringLiquibase {

    @Value("${spring.liquibase.change-log}")
    private String defaultLiquibaseChangelog;
    private final Environment env;
    private final SqlMigrationEventPublisher publisher;
    private final DataSource datasource;
    private Boolean migrationSuccess;

    @Autowired
    public SpringLiquibaseConfig(DataSource datasource, SqlMigrationEventPublisher publisher, Environment env) {
        this.datasource = datasource;
        this.publisher = publisher;
        this.env = env;
    }

    @Override
    public void afterPropertiesSet() {
        try {
            if (env.acceptsProfiles(Profiles.of(EnvironmentType.DEV.name(), EnvironmentType.SIT.name(), EnvironmentType.UAT.name(), EnvironmentType.PROD.name()))) {
                CompletableFuture.runAsync(() -> {
                    try {
                        log.info("Starting Liquibase asynchronously, your database might not be ready at startup!");
                        initDb();
                    } catch (LiquibaseException e) {
                        log.error("Liquibase could not start correctly, your database is NOT ready: {}", e.getMessage(), e);
                        publisher.publishEvent(false);
                    }
                }).whenComplete((aVoid, throwable)
                        -> publisher.publishEvent(throwable == null || StringUtils.isBlank(throwable.getMessage())));
            } else {
                log.info("Starting Liquibase synchronously");
                initDb();
                migrationSuccess = true;
            }
        } catch (LiquibaseException e) {
            log.error("Liquibase could not start correctly, your database is NOT ready: {}", e.getMessage(), e);
            publisher.publishEvent(false);
            migrationSuccess = false;
        }
    }

    protected void initDb() throws LiquibaseException {
        StopWatch watch = new StopWatch();
        watch.start();
        super.afterPropertiesSet();
        watch.stop();
        log.info(String.format("Liquibase migration done in {%s} s", watch.getTotalTimeSeconds()));
    }

    @Override
    public DataSource getDataSource() {
        return datasource;
    }

    @Override
    public String getChangeLog() {
        return defaultLiquibaseChangelog;
    }

    @EventListener(classes = ApplicationStartedEvent.class)
    public void appStarted() {
        if (migrationSuccess != null && migrationSuccess) {
            publisher.publishEvent(true);
        }
    }
}
