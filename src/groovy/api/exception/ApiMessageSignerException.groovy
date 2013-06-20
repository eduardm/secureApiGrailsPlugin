package api.exception

@SuppressWarnings("serial")
public class ApiMessageSignerException extends ApiException {

    public ApiMessageSignerException(String message) {
        super(message);
    }

    public ApiMessageSignerException(Throwable cause) {
        super(cause);
    }

    public ApiMessageSignerException(String message, Throwable cause) {
        super(message, cause);
    }

}