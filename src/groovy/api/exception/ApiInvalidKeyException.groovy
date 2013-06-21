package api.exception

class ApiInvalidKeyException extends ApiException {

    private static final long serialVersionUID = 1

    ApiInvalidKeyException(String message) {
        super(message)
    }

    ApiInvalidKeyException(Throwable cause) {
        super(cause)
    }

    ApiInvalidKeyException(String message, Throwable cause) {
        super(message, cause)
    }
}
