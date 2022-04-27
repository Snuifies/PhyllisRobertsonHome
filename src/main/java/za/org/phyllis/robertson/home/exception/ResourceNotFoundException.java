package za.org.phyllis.robertson.home.exception;

/**
 * @author snuif
 */
public class ResourceNotFoundException extends Exception {

    private final static String RESOURCE_NOT_FOUND = "Resource Not Found for %s";

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String resource) {
        super(String.format(RESOURCE_NOT_FOUND, resource));
    }

    public ResourceNotFoundException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ResourceNotFoundException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ResourceNotFoundException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
