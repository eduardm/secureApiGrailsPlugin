package api.exception

public class ApiInvalidKeyException extends ApiException {

    public ApiInvalidKeyException(String message) {
        super(message);
    }

    public ApiInvalidKeyException(Throwable cause) {
        super(cause);
    }

    public ApiInvalidKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}
