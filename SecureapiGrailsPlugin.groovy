import api.ApiRequestAuthorizer

class SecureapiGrailsPlugin {
    // the plugin version
    def version = "1.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Secureapi Plugin" // Headline display name of the plugin
    def author = "Eduard Martini"
    def authorEmail = "eduard.martini@gmail.com"
    def description = '''
SecureApi is a Grails plugin that provides authentication to your app API. It implements same security model as Amazon is using for the AWS API, based on OAuth 1.1 specs,
but with reduced compelxity.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/secureapi"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "Github", url: "https://github.com/eduardm/secureApiGrailsPlugin/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/eduardm/secureApiGrailsPlugin" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        apiRequestAuthorizer(ApiRequestAuthorizer)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
