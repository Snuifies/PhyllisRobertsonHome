package za.org.phyllis.robertson.home.event.publisher;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.event.SqlMigrationDoneEvent;

/**
 * Publisher for SqlMigrationDoneEvent events
 */
@Log4j2
@Component
public class SqlMigrationEventPublisher {

    private final ApplicationEventPublisher publisher;

    SqlMigrationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Transactional
    public void publishEvent(final boolean success) {
        publisher.publishEvent(new SqlMigrationDoneEvent(this, success));
    }
}
