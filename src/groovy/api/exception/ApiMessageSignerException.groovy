package api.exception

class ApiMessageSignerException extends ApiException {

    private static final long serialVersionUID = 1

    ApiMessageSignerException(String message) {
        super(message)
    }

    ApiMessageSignerException(Throwable cause) {
        super(cause)
    }

    ApiMessageSignerException(String message, Throwable cause) {
        super(message, cause)
    }
}
