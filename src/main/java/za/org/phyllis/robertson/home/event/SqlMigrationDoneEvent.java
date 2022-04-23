package za.org.phyllis.robertson.home.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SqlMigrationDoneEvent extends ApplicationEvent {

    private static final long serialVersionUID = 7867750798242865954L;
    private final boolean success;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SqlMigrationDoneEvent(Object source, final boolean success) {
        super(source);
        this.success = success;
    }
}
