import grails.util.Environment
import api.ApiRequestAuthorizer

beans = {
    if (Environment.current == Environment.TEST) {
        importBeans("file:test/integration/resources/META-INF/config/spring/applicationContext-test.xml")
    }
    apiRequestAuthorizer(ApiRequestAuthorizer)
}
