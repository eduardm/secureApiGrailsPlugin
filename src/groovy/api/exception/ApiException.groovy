package api.exception

abstract class ApiException extends Exception {

    private static final long serialVersionUID = 1

    ApiException(String message) {
        super(message)
    }

    ApiException(Throwable cause) {
        super(cause)
    }

    ApiException(String message, Throwable cause) {
        super(message, cause)
    }
}
