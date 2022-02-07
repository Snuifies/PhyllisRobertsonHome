package za.org.phyllis.robertson.home.event.publisher;

import za.org.phyllis.robertson.home.event.SqlMigrationDoneEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
