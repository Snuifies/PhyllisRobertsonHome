package spring.security.exception;

/**
 * @author snuif
 */
public class ResourceAlreadyExistsException extends RuntimeException {

    public static final String RESOURCE_ALREADY_EXIST = "Resource Already Exists for %s";

    public ResourceAlreadyExistsException(String detail) {
        super(String.format(RESOURCE_ALREADY_EXIST, detail));
    }

}
