Secure API Grails plugin
==========================

Simple Grails plugin to add Oauth like authorization to existing API


# Introduction

This project contains the open source **Secure API Grail Plugin** that allows you to easily add authorization to your provided API.

I created this plugin because there are several plugins that handles the client side (for connecting to already secured APIs), but none for the API providers.

**Secure API Grail Plugin** provides the following Grails artefacts:

* **SecureApiService** - A service that expose a single method *isAuthorizeRequest* to be used in your filters or interceptor before executing and API call.



# Installation

Declare the plugin dependency in the BuildConfig.groovy file, as shown here:

```groovy
grails.project.dependency.resolution = {
    inherits("global") { }
  	log "info"
		repositories {
				//your repositories
		}
		dependencies {
				//your regular dependencies
		}
		plugins {
				//here go your plugin dependencies
				runtime ':secureapi:1.2'
		}
}
```

# Config

Add your clients pairs of key/secret in *grails-app/conf/Config.groovy_:*

```groovy
[REQUIRED]
grails.secure.api.consumers = ["my_first_api_user": "the_secret_of_my_first_api_user", "my_second_api_user": "the_secret_of_my_second_api_user"]
```

# Getting started with a demo app

If you want to quickly run the plugin on a demo app, you can download [Secure Api Sample Implementation App](https://github.com/eduardm/secureApiSampleImplementationApp) and start it on port 80.

If you want to easily test the implementation using a GUI, you can download [Secure API Simple Client App](https://github.com/eduardm/secureApiSimpleClient). This app can be used as sample client implementaion for your API users.

# Documentation

Project documentation is located here :

* [Reference Documentation](https://github.com/eduardm/secureApiGrailsPlugin/wiki)

# Latest releases

* 2013-06-20 **V1.2** : First public release
* 2013-06-18 **V1.1** : Non public release
* 2013-06-03 **V1.0** : Non public release


# Bugs

To report any bug, please use the project [Issues](https://github.com/eduardm/secureApiGrailsPlugin/issues) section on GitHub.

# Beta status

This is a **beta release**.
The underlying APIs are generally stable, however we may make changes to the library in response to developer feedback.

# Feedback

The **Secure API Grail Plugin** is licensed under the [Apache Licence, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
