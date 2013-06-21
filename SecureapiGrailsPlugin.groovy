import api.ApiRequestAuthorizer

class SecureapiGrailsPlugin {
    def version = "1.2"
    def grailsVersion = "2.0 > *"
    def title = "Secureapi Plugin"
    def author = "Eduard Martini"
    def authorEmail = "eduard.martini@gmail.com"
    def description = 'Provides authentication to your app API. It implements same security model as Amazon is using for the AWS API, based on OAuth 1.1 specs, but with reduced compelxity.'

    def documentation = "http://grails.org/plugin/secureapi"

    def license = "APACHE"
    def issueManagement = [ system: "Github", url: "https://github.com/eduardm/secureApiGrailsPlugin/issues" ]
    def scm = [ url: "https://github.com/eduardm/secureApiGrailsPlugin" ]

    def doWithSpring = {
        apiRequestAuthorizer(ApiRequestAuthorizer)
    }
}
