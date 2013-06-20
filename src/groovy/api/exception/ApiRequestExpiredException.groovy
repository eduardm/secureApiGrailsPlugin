package api.exception

class ApiRequestExpiredException extends ApiException {

    private static final long serialVersionUID = 1

    ApiRequestExpiredException(String message) {
        super(message)
    }

    ApiRequestExpiredException(Throwable cause) {
        super(cause)
    }

    ApiRequestExpiredException(String message, Throwable cause) {
        super(message, cause)
    }
}
