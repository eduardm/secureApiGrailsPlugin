package api.exception

public class ApiInvalidSignatureException extends ApiException {
    public ApiInvalidSignatureException(String message) {
        super(message);
    }

    public ApiInvalidSignatureException(Throwable cause) {
        super(cause);
    }

    public ApiInvalidSignatureException(String message, Throwable cause) {
        super(message, cause);
    }
}