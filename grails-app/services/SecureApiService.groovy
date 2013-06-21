import api.ApiRequestAuthorizer
import api.exception.ApiInvalidKeyException
import api.exception.ApiInvalidSignatureException
import api.exception.ApiMessageSignerException
import api.exception.ApiRequestExpiredException

class SecureApiService {
    static transactional = false

    ApiRequestAuthorizer apiRequestAuthorizer
    def grailsApplication

    int isAuthorizedRequest(request) {
        int status
        def consumers = grailsApplication.config.grails.secure.api.consumers
        try {
            if (apiRequestAuthorizer.isAuthorized(request, consumers)) {
                status = 200
            }
        } catch (ApiRequestExpiredException e) {
            log.error("Timestamp not ok", e)
            status = 412
        } catch (ApiInvalidKeyException e) {
            log.error("Invalid key", e)
            status = 417
        } catch (ApiInvalidSignatureException e) {
            log.error("Invalid signature", e)
            status = 401
        } catch (ApiMessageSignerException e) {
            log.error("Signer exception", e)
            status = 400
        } catch (Exception e) {
            log.error("Api auth exception", e)
            status = 500
        }
        finally {
            return status
        }
    }
}
