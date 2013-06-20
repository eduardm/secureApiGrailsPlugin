package api.exception

class ApiInvalidSignatureException extends ApiException {

    private static final long serialVersionUID = 1

    ApiInvalidSignatureException(String message) {
        super(message)
    }

    ApiInvalidSignatureException(Throwable cause) {
        super(cause)
    }

    ApiInvalidSignatureException(String message, Throwable cause) {
        super(message, cause)
    }
}