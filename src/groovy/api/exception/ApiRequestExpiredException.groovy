package api.exception

public class ApiRequestExpiredException extends ApiException {
    public ApiRequestExpiredException(String message) {
        super(message);
    }

    public ApiRequestExpiredException(Throwable cause) {
        super(cause);
    }

    public ApiRequestExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
