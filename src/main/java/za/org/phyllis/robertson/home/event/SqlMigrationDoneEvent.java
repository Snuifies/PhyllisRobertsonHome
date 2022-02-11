package za.org.phyllis.robertson.home.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SqlMigrationDoneEvent extends ApplicationEvent {

    private static final long serialVersionUID = 7867750798242865954L;
    private final boolean success;

    public SqlMigrationDoneEvent(Object source, final boolean success) {
        super(source);
        this.success = success;
    }
}
