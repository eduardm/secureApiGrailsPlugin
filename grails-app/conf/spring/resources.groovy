import grails.util.Environment
import grails.util.GrailsUtil

import api.ApiRequestAuthorizer

// Place your Spring DSL code here
beans = {
    switch (GrailsUtil.environment) {
        case Environment.DEVELOPMENT.getName():
        case Environment.PRODUCTION.getName():
            break;
        case Environment.TEST.getName():
            importBeans("file:test/integration/resources/META-INF/config/spring/applicationContext-test.xml")
            break;
    }
    apiRequestAuthorizer(ApiRequestAuthorizer)
}
