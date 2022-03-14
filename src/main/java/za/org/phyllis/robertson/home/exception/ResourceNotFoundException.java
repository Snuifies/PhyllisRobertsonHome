package za.org.phyllis.robertson.home.exception;
/**
 *
 * @author snuif
 */
public class ResourceNotFoundException extends RuntimeException {

    public static final String RESOURCE_NOT_FOUND = "Resource Not Found for %s";

    public ResourceNotFoundException(String detail) {
        super(String.format(RESOURCE_NOT_FOUND, detail));
    }

}
