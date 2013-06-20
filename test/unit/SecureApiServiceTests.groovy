import grails.test.mixin.TestFor

import org.junit.Before
import org.junit.Test

import api.ApiRequestAuthorizer

@TestFor(SecureApiService)
class SecureApiServiceTests {
    def secureApiService
    static mockedValidRequest = new Expando(
            parameterMap: [
                    "key": ["my_first_api_user"],
                    "signature": ["GaJ/66LU+HBRfvlMcQK/b1hF3ME="],
                    "timestamp": ["1371725366979"]
            ],
            queryString: "key=my_first_api_user&timestamp=1371725366979&signature=GaJ%2F66LU%2BHBRfvlMcQK%2Fb1hF3ME%3D",
            method: "GET",
            scheme: "http",
            serverName: "localhost",
            forwardURI: "/secureApiSampleApp/api/getUser/1"
    )
    static mockedInvalidKeyRequest = new Expando(
            parameterMap: [
                    "key": [""],
                    "signature": ["GaJ/66LU+HBRfvlMcQK/b1hF3ME="],
                    "timestamp": ["1371725366979"]
            ],
            queryString: "key=my_first_api_user&timestamp=1371725366979&signature=GaJ%2F66LU%2BHBRfvlMcQK%2Fb1hF3ME%3D",
            method: "GET",
            scheme: "http",
            serverName: "localhost",
            forwardURI: "/secureApiSampleApp/api/getUser/1"
    )
    static mockedInvalidTimestampRequest = new Expando(
            parameterMap: [
                    "key": ["my_first_api_user"],
                    "signature": ["GaJ/66LU+HBRfvlMcQK/b1hF3ME="],
                    "timestamp": ["302"]
            ],
            queryString: "key=my_first_api_user&timestamp=1371725366979&signature=GaJ%2F66LU%2BHBRfvlMcQK%2Fb1hF3ME%3D",
            method: "GET",
            scheme: "http",
            serverName: "localhost",
            forwardURI: "/secureApiSampleApp/api/getUser/1"
    )
    static mockedInvalidSignatureRequest = new Expando(
            parameterMap: [
                    "key": ["my_first_api_user"],
                    "signature": ["GaJ/66LU+HBRfvlMcQK/b1hF3MA="],
                    "timestamp": ["1371725366979"]
            ],
            queryString: "key=my_first_api_user&timestamp=1371725366979&signature=GaJ%2F66LU%2BHBRfvlMcQK%2Fb1hF3MA%3D",
            method: "GET",
            scheme: "http",
            serverName: "localhost",
            forwardURI: "/secureApiSampleApp/api/getUser/1"
    )

    @Before
    void setUp() {
        secureApiService = new SecureApiService()
        def apiRequestAuthorizer = new ApiRequestAuthorizer() {
            @Override
            protected Long getCurrentTimestamp() {
                return 1371725366980L
            }
        }
        secureApiService.apiRequestAuthorizer = apiRequestAuthorizer
    }

    @Test
    void testValidRequest() {
        def result = secureApiService.isAuthorizedRequest(mockedValidRequest)
        assertEquals(200, result)
    }

    @Test
    void testInvalidKey() {
        def result = secureApiService.isAuthorizedRequest(mockedInvalidKeyRequest)
        assertEquals(417, result)
    }

    @Test
    void testInvalidTimestamp() {
        def result = secureApiService.isAuthorizedRequest(mockedInvalidTimestampRequest)
        assertEquals(412, result)
    }

    @Test
    void testInvalidSignature() {
        def result = secureApiService.isAuthorizedRequest(mockedInvalidSignatureRequest)
        assertEquals(401, result)
    }
}
