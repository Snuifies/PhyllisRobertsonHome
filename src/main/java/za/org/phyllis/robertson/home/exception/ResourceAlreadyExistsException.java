package za.org.phyllis.robertson.home.exception;
/**
 *
 * @author snuif
 */
public class ResourceAlreadyExistsException extends RuntimeException {

    public static final String RESOURCE_ALREADSY_EXIST = "Resource Already Exists for %s";

    public ResourceAlreadyExistsException(String detail) {
        super(String.format(RESOURCE_ALREADSY_EXIST, detail));
    }

}